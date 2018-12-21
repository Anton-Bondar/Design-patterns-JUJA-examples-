package com.anbo.juja.patterns.abstractFactory_13.classic;

/**
 * Created by oleksandr.baglai on 22.11.2015.
 */
// конкретный продукт A2
public class ConcreteProductA2 implements Product2 {

    private String one;
    private String another;

    @Override
    public void setOne(String data) {
        this.one = data;
    }

    @Override
    public void setAnother(String data) {
        this.another = data;
    }

    @Override
    public String toString() {
        return "printedA: " + one + "-" + another;
    }
}
