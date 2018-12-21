package com.anbo.juja.patterns.objectPool_19.sample.simpleConnectionPool;

import ua.com.juja.patterns.objectPool.IdGenerator;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by oleksandr.baglai on 28.01.2016.
 */
public class ConnectionPool {

    private final int maxCount;
    private int openedCount;
    private Queue<Connection> pool;
    private ConnectionFactory factory;

    public ConnectionPool(int maxCount, ConnectionFactory factory) {
        // заметь потокобезопасная коллекция
        this.pool = new ConcurrentLinkedQueue<Connection>();
        this.openedCount = 0;
        this.factory = factory;
        this.maxCount = maxCount;
    }

    // метод для оборачивания ресурса в прокси
    // прокси реализует тот же интерфейс что и ресурс
    // но на его метод close и в случае возникновения исплючений
    // он возвращает пару (прокси + ресурс) в пул
    private Connection proxy(final Connection connection) {
        // это для того чтобы айдишечки у коннекшенов были,
        // в продакшене этого кода бы небыло, только для целей тренинга
        IdGenerator.put(connection);

        Connection proxy = (Connection) Proxy.newProxyInstance(
                Connection.class.getClassLoader(),
                new Class[]{Connection.class},
                new InvocationHandler() {
                    // этот метод будет вызываться при вызове любого метода прокси
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        // если это метод close, тогда ресурс надо вернуть на место
                        if (method.getName().equals("close")) {
                            ConnectionPool.this.put((Connection) proxy);
                            return null;
                        }
                        // метод toString переопределяем тоже
                        if (method.getName().equals("toString")) {
                            return "CONN" + IdGenerator.get(connection);
                        }
                        // иначе делаем ппоытку вызова реального метода на ресурсе
                        try {
                            return method.invoke(connection, args);
                        } catch (Exception e) {
                            // а в случае ошибки, например, можем вернуть ресурс на место
                            // ObjectPool.this.put((Connection) proxy);
                            // или пусть клиент сам позаботится об этом
                            throw e;
                        }
                    }
                });
        return proxy;
    }

    // этим методом мы извлекаем ресурсы для работы с ними
    // заметь, только один поток может находиться внутри этого метода
    // лочится по монитору this объекта
    public synchronized Connection get() {
        Connection connection;

        // если мы не переполнили наш пул
        if (openedCount != maxCount) {
            // то пробуем единоразово достать свободный элемент, если он есть
            if ((connection = pool.poll()) == null) {
                // если его нет, тогда просим фектори сгенерить новый
                connection = proxy(factory.createConnection());
            }
        } else {
            // иначе мы залипаем в попытке достать свободный -
            // тот, кто взял элемент ведь должен его вернуть рано или поздно
            while ((connection = pool.poll()) == null) {
                // небольшая задержка
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        // сигнализируем о том, что еще один элемент взят
        openedCount++;
        System.out.println("\tGet " + connection + ", opened = " + openedCount);
        return connection;
    }

    // это обхъект для лока другого метода put
    private final Object putLock = new Object();
    // этим методом мы возвращаем ресурс на место (если его там нет),
    // чтобы его можно было повторно использовать
    private void put(Connection connection) {
        // я хочу чтобы все, что внутри выполняется выполнялось только одним потоком
        // но брать монитор объекта this не могу, так как будет deadlock
        // попробуй напиши тут - иногда тесты будут подвисать
        // synchronized (this) {
        synchronized (putLock) {
            if (!pool.contains(connection)) {
                openedCount--;
                pool.add(connection);

                System.out.println("\tPut " + connection + ", opened = " + openedCount);
            }
        }
    }

    public int getMaxCount() {
        return maxCount;
    }
}
