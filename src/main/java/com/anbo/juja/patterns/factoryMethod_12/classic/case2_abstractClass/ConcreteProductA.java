package com.anbo.juja.patterns.factoryMethod_12.classic.case2_abstractClass;

/**
 * Created by oleksandr.baglai on 11.11.2015.
 */
// конкретный продукт А
public class ConcreteProductA implements Product {

    private String config;

    @Override
    public String process(String data) {
        return String.format("ConcreteProductA[%s]: %s", config, data);
    }

    @Override
    public void setup(String config) {
        this.config = config;
    }

}
