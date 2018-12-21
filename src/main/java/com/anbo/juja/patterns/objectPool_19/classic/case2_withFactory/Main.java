package com.anbo.juja.patterns.objectPool_19.classic.case2_withFactory;

/**
 * Created by oleksandr.baglai on 28.01.2016.
 */
// класс-запускатор
public class Main {

    public static void main(String[] args) {
        // эта фабрика инкапсулирует в себе логику создания ресурсов
        // это шаблон Фабричный Метод (Factory Method)
        ObjectFactory factory = new ObjectFactoryImpl();

        // создаем пул ресурсов, в котором будет не больше 3х элементов
        // клиенту всего хватит!
        ObjectPool pool = new ObjectPool(factory);

        // конфигурируем клиента пулом ресурсов
        Client client = new Client(pool);

        // выполняем полезную логику
        client.doSomething();

        // вывод:
        // create Resource@1 from factory-method
        // get Resource@1 from pool
        // create Resource@2 from factory-method
        // get Resource@2 from pool
        // Resource@1 processed: data1
        // put Resource@1 to pool
        // get Resource@1 from pool
        // Resource@1 processed: data3
        // put Resource@1 to pool
        // Resource@2 processed: data2
        // put Resource@2 to pool
    }
}
