package com.anbo.juja.patterns.factoryMethod_12.classic.case3_switchCase;

/**
 * Created by oleksandr.baglai on 11.11.2015.
 */
// эта фабрика умеет создавать любые типа объектов по параметру передаваемому на вход
public class ConcreteCreator implements Creator {

    @Override
    public Product createProduct(String productName) {
        if (productName.equals("Product A")) {
            return new ConcreteProductA();
        }

        if (productName.equals("Product B")) {
            return new ConcreteProductB();
        }

        throw new UnsupportedOperationException("Unexpected product: " + productName);
    }
}
