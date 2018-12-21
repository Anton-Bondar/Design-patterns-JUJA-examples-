package com.anbo.juja.patterns.factoryMethod_12.classic.case2_abstractClass;

/**
 * Created by oleksandr.baglai on 11.11.2015.
 */
// эта фабрика создает свой продукт
public class ConcreteCreatorA extends Creator {

    @Override
    protected Product factoryMethod() {
        return new ConcreteProductA();
    }

}
