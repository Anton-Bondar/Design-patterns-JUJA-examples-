package com.anbo.juja.patterns.strategy_03.inheritance;

/**
 * Created by oleksandr.baglai on 02.09.2015.
 */
public class ConcreteStrategyA extends Strategy {
    @Override
    public Object algorithm(Object input) {
        return String.format("toString:'%s'", input);
    }
}
