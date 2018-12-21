package com.anbo.juja.patterns.nullObject_15.classic.case1_interfaces;

/**
 * Created by oleksandr.baglai on 09.12.2015.
 */
// пример клиента
public class Client2 {

    private String data = "data";

    // который на вход метода принимает объект
    // и с ним деалает что-то сразу
    public void doSomething(Abstraction abstraction) {
        abstraction.request(data);
    }
}
