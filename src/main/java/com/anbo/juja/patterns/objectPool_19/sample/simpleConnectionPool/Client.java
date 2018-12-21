package com.anbo.juja.patterns.objectPool_19.sample.simpleConnectionPool;

import java.sql.*;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by oleksandr.baglai on 28.01.2016.
 */
// клиент, содержащий полезную логику работы с базой через пул коннекшенов
public class Client {

    // PostgreSQL или HSQLDB?
    private boolean isPostgreSQL;

    // пул коннекшенов - тут будут все коннекшены, которыми можно будет воспользоваться
    private ConnectionPool pool;

    // а это пул потоков, то есть приложение у нас многопоточное
    // и запросы будут выполняться каждый в своем отдельном потоке
    private ExecutorService executor;

    // конфигурация через конструктор
    public Client(ConnectionPool pool, boolean isPostgreSQL) {
        this.pool = pool;
        this.isPostgreSQL = isPostgreSQL;
        // пул потоков содержит столько же потоков, сколько и пул коннекшенов
        // пул потоков реализован с помощью java.util.concurrent.Executors
        this.executor = Executors.newFixedThreadPool(pool.getMaxCount());
    }

    // полезная логика
    public void run(List<String> list) throws Exception {
        // вначале чистим базу
        createTable();

        // потом в отдельных потоках вставляем каждую запись из списка list
        for (final String data : list) {
            // это такой синтаксис запуска потока через Callable
            // он удобен тем, что у него есть throws Exception :)
            executor.submit(new Callable<Void>() {
                @Override
                public Void call() throws Exception {
                    // апдейлим табличку
                    // тут у нас снова замыкание, заметил final в for?
                    updateTable(data);
                    return null;
                }
            });
        }

        // сигнализируем всем потокам, что им пора заваршаться
        // но они проигронят это :)
        executor.shutdown();
        // а пока не завершатся, мы подождем в этом методе
        executor.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);

        // и напечатаем результат в консоли
        printTable();
    }

    // дальше идут три метода для работы с табличкой

    // создание таблички
    private void createTable() throws SQLException {
        System.out.println("Create table START...");

        // try with resources - доступен с java 1.7
        // в таком формате подразумевается блок finally
        // в котором для каждого Closeable ресурса будет
        // произведено закрытие, то есть будет выполнено
        // statement.close() и connection.close()
        try (Connection connection = pool.get();
             Statement statement = connection.createStatement())
        {
            statement.executeUpdate("DROP TABLE IF EXISTS " + getSchema() + "mytable;");
            if (isPostgreSQL) {
                statement.executeUpdate("CREATE TABLE mytable (id integer, value text);");
            } else {
                statement.executeUpdate("CREATE TABLE mytable (id IDENTITY, value VARCHAR(100));");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Create table DONE!");
    }

    // обновление таблички
    private void updateTable(String data) {
        System.out.println("Update table with: " + data + " START...");

        try (Connection connection = pool.get();
             PreparedStatement statement = connection.prepareStatement("INSERT INTO " + getSchema() + "mytable (value) VALUES(?);")) {
            statement.setString(1, data);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Update table with: " + data + " DONE!");
    }

    // печать таблички на экране
    private void printTable() throws Exception {
        System.out.println("Print data START...");

        try (Connection connection = pool.get();
             Statement statement = connection.createStatement())
        {
            ResultSet resultSet = statement.executeQuery("SELECT id, value FROM " + getSchema() + "mytable;");
            while (resultSet.next()) {
                System.out.println("\t\t" + resultSet.getInt(1) + " " + resultSet.getString(2));
            }

            if (!isPostgreSQL) {
                statement.execute("SHUTDOWN");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Print data DONE!");
    }

    // у разных баз данных SQL диалекты разные,
    // вот у PostgreSQL таблички идут со схемой 'public.table'
    // а у HSQLDB нет
    private String getSchema() {
        return (isPostgreSQL)?"public.":"";
    }
}
