package com.anbo.juja.patterns.simpleFactory_14.classic.case2_inheritance;

/**
 * Created by oleksandr.baglai on 30.11.2015.
 */
// один продукт
public class ConcreteProductA extends AbstractProduct {
    @Override
    public String getSomething() {
        return somethingCommon() + "_somethingA";
    }
}
