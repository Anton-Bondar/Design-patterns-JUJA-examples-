package com.anbo.juja.patterns.nullObject_15.classic.case2_abstractClass;

/**
 * Created by oleksandr.baglai on 09.12.2015.
 */
public class Main {

    public static void main(String[] args) {
        // где-то у нас случилось создание объекта
        AbstractObject object = new ConcreteObject();

        // a если будет null то ждем NPE
        // AbstractObject object = null;

        // но чтобы не вставлять везде ифы на проверку на null
        // можно запустить клиенту null-объект
        // AbstractObject object = new NullObject();

        // клиент
        Client1 client1 = new Client1(object);
        client1.doSomething("data");

        printBreak();

        // другой клиент
        Client2 client2 = new Client2();
        client2.doSomething(object);

        // их вывод:
        // либо
        //
        // request1('data')
        // request2() = result2
        // request3()
        // request4('data', 'result2')
        // result2data_changed
        // -----------------------
        // request1('data')
        // request2() = result2
        // request3()
        // request4('data', 'result2')
        // result2data_changed
        //
        // либо ничего :)
    }

    private static void printBreak() {
        System.out.println("\n-----------------------");
    }
}
