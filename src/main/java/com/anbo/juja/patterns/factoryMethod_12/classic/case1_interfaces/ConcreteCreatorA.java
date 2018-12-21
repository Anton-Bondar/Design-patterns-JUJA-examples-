package com.anbo.juja.patterns.factoryMethod_12.classic.case1_interfaces;

/**
 * Created by oleksandr.baglai on 11.11.2015.
 */
// эта фабрика создает свой продукт
public class ConcreteCreatorA implements Creator {

    @Override
    public Product factoryMethod() {
        return new ConcreteProductA();
    }
}
