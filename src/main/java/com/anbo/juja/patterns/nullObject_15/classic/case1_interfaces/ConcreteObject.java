package com.anbo.juja.patterns.nullObject_15.classic.case1_interfaces;

/**
 * Created by oleksandr.baglai on 09.12.2015.
 */
// это какой-то реальный объект, делающий полезную логику
public class ConcreteObject implements Abstraction {

    @Override
    public void request(String input) {
        // в данном случае печатающий в консоль
        // полезно жеж!
        System.out.println(input);
    }
}
