package com.anbo.juja.patterns.factoryMethod_12.classic.case1_interfaces;

/**
 * Created by oleksandr.baglai on 11.11.2015.
 */
// а эта - свой
public class ConcreteCreatorB implements Creator {

    @Override
    public Product factoryMethod() {
        return new ConcreteProductB();
    }
}
