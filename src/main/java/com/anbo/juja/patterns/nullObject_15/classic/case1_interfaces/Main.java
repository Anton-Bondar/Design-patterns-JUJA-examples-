package com.anbo.juja.patterns.nullObject_15.classic.case1_interfaces;

/**
 * Created by oleksandr.baglai on 09.12.2015.
 */
public class Main {
    public static void main(String[] args) {
        // где-то у нас случилось создание объекта
        Abstraction abstraction = new ConcreteObject();

        // a если будет null то ждем NPE
        // Abstraction abstraction = null;

        // но чтобы не вставлять везде ифы на проверку на null
        // можно запустить клиенту null-объект
        // Abstraction abstraction = new NullObject();

        // клиент
        Client1 client1 = new Client1(abstraction);
        client1.doSomething("data");

        printBreak();

        // другой клиент
        Client2 client2 = new Client2();
        client2.doSomething(abstraction);

        // их вывод:
        // либо
        //
        // data_changed
        // -----------------------
        // data
        //
        // либо ничего :)
    }

    private static void printBreak() {
        System.out.println("-----------------------");
    }
}
