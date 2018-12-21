package com.anbo.juja.patterns.nullObject_15.classic.case1_interfaces;

/**
 * Created by oleksandr.baglai on 09.12.2015.
 */
// пример клиента
public class Client1 {

    private Abstraction abstraction;

    // который принимает через конструктор объект ставит в поле
    public Client1(Abstraction abstraction) {
        this.abstraction = abstraction;
    }

    // и позже что-то сделает
    // на стратегию похоже, правда? :)
    public void doSomething(String data) {
        abstraction.request(data + "_changed");
    }
}
