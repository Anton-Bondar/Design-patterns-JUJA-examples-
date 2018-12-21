package com.anbo.juja.patterns.abstractFactory_13.classic;

/**
 * Created by oleksandr.baglai on 22.11.2015.
 */
// конкретный продукт B3
public class ConcreteProductB3 implements Product3 {

    @Override
    public String getOne() {
        return "oneB";
    }

    @Override
    public String getAnother() {
        return "anotherB";
    }

    @Override
    public String getSomething() {
        return "somethingB";
    }
}
