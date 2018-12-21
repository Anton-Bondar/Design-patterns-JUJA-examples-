package com.anbo.juja.patterns.abstractFactory_13.classic;

/**
 * Created by oleksandr.baglai on 22.11.2015.
 */
// конкретный продукт A3
public class ConcreteProductA3 implements Product3 {

    @Override
    public String getOne() {
        return "oneA";
    }

    @Override
    public String getAnother() {
        return "anotherA";
    }

    @Override
    public String getSomething() {
        return "somethingA";
    }
}
