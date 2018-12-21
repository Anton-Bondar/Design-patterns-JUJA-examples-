package com.anbo.juja.patterns.abstractFactory_13.classic;

/**
 * Created by oleksandr.baglai on 22.11.2015.
 */
// конкретный продукт A1
public class ConcreteProductA1 implements Product1 {

    @Override
    public String process(String data) {
        return String.format("changedA: %s", data);
    }
}
