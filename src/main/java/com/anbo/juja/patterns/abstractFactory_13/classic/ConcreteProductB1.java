package com.anbo.juja.patterns.abstractFactory_13.classic;

/**
 * Created by oleksandr.baglai on 22.11.2015.
 */
// конкретный продукт B1
public class ConcreteProductB1 implements Product1 {

    @Override
    public String process(String data) {
        return String.format("changedB: %s", data);
    }
}
