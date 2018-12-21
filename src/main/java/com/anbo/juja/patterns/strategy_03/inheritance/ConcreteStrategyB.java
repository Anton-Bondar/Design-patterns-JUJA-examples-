package com.anbo.juja.patterns.strategy_03.inheritance;

/**
 * Created by oleksandr.baglai on 02.09.2015.
 */
public class ConcreteStrategyB extends Strategy {
    @Override
    public Object algorithm(Object input) {
        return String.format("length:%s", input.toString().length());
    }
}
