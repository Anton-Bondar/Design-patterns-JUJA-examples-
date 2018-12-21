package com.anbo.juja.patterns.simpleFactory_14.classic.case1_interface;

/**
 * Created by oleksandr.baglai on 30.11.2015.
 */
// второй продукт
public class ConcreteProductB implements Product {
    @Override
    public String getSomething() {
        return "somethingB";
    }
}
