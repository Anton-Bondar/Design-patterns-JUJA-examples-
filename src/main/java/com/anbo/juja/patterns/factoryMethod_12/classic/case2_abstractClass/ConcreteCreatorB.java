package com.anbo.juja.patterns.factoryMethod_12.classic.case2_abstractClass;

/**
 * Created by oleksandr.baglai on 11.11.2015.
 */
// а эта - свой
public class ConcreteCreatorB extends Creator {

    @Override
    protected Product factoryMethod() {
        return new ConcreteProductB();
    }

}
