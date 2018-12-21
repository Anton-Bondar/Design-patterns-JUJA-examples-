package com.anbo.juja.patterns.factoryMethod_12.classic.case2_abstractClass;

/**
 * Created by oleksandr.baglai on 11.11.2015.
 */
// конкретный продукт B
public class ConcreteProductB implements Product {

    private String config;

    @Override
    public String process(String data) {
        return String.format("ConcreteProductB[%s]: %s", config, data);
    }

    @Override
    public void setup(String config) {
        this.config = config;
    }
}
