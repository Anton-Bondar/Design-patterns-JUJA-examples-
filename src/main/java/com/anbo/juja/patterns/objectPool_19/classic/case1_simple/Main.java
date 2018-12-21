package com.anbo.juja.patterns.objectPool_19.classic.case1_simple;

/**
 * Created by oleksandr.baglai on 28.01.2016.
 */
// класс-запускатор
public class Main {

    public static void main(String[] args) {
        case1_enoughResources();

        printBreak();

        case2_notEnoughResources();
    }

    private static void printBreak() {
        System.out.println("-------------------------------");
    }

    private static void case1_enoughResources() {
        // создаем пул ресурсов, в котором будет не больше 3х элементов
        // клиенту всего хватит!
        ObjectPool pool = new ObjectPool(3);

        // конфигурируем клиента пулом ресурсов
        Client client = new Client(pool);

        // выполняем полезную логику
        client.doSomething();

        // вывод:
        // init pool...
        // put Resource@1 to pool
        // put Resource@2 to pool
        // put Resource@3 to pool
        // ...init done!
        // get Resource@1 from pool
        // get Resource@2 from pool
        // Resource@1 processed: data1
        // put Resource@1 to pool
        // get Resource@3 from pool
        // Resource@3 processed: data3
        // put Resource@3 to pool
        // Resource@2 processed: data2
        // put Resource@2 to pool
    }

    private static void case2_notEnoughResources() {
        // создаем пул ресурсов, в котором будет не больше 2х элементов
        // чего недостаточно для выполнения запросов клиента
        // а потому один из ресурсов будет использовать дважды
        ObjectPool pool = new ObjectPool(2);

        // конфигурируем клиента пулом ресурсов
        Client client = new Client(pool);

        // выполняем полезную логику
        client.doSomething();

        // вывод:
        // init pool...
        // put Resource@1 to pool
        // put Resource@2 to pool
        // ...init done!
        // get Resource@1 from pool       <---- берем первый ресурс
        // get Resource@2 from pool       <---- берем второй ресурс
        // Resource@1 processed: data1
        // put Resource@1 to pool
        // get Resource@1 from pool       <---- берем (снова) первый ресурс
        // Resource@1 processed: data3
        // put Resource@1 to pool
        // Resource@2 processed: data2
        // put Resource@2 to pool
    }
}
