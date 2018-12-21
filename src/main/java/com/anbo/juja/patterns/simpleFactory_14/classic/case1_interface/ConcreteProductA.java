package com.anbo.juja.patterns.simpleFactory_14.classic.case1_interface;

/**
 * Created by oleksandr.baglai on 30.11.2015.
 */
// один продукт
public class ConcreteProductA implements Product {
    @Override
    public String getSomething() {
        return "somethingA";
    }
}
