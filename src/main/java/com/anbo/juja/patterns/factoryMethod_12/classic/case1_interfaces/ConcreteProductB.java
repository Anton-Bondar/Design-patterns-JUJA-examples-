package com.anbo.juja.patterns.factoryMethod_12.classic.case1_interfaces;

/**
 * Created by oleksandr.baglai on 11.11.2015.
 */
// конкретный продукт B
public class ConcreteProductB implements Product {

    @Override
    public String process(String data) {
        return String.format("ConcreteProductB: %s", data);
    }
}
