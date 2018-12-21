package com.anbo.juja.patterns.simpleFactory_14.classic.case2_inheritance;

/**
 * Created by oleksandr.baglai on 30.11.2015.
 */
// второй продукт
public class ConcreteProductB extends AbstractProduct {
    @Override
    public String getSomething() {
        return "somethingB_" + somethingCommon();
    }
}
