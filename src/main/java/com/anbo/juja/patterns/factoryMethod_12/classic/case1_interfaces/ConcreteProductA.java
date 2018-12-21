package com.anbo.juja.patterns.factoryMethod_12.classic.case1_interfaces;

/**
 * Created by oleksandr.baglai on 11.11.2015.
 */
// конкретный продукт А
public class ConcreteProductA implements Product {

    @Override
    public String process(String data) {
        return String.format("ConcreteProductA: %s", data);
    }

}
