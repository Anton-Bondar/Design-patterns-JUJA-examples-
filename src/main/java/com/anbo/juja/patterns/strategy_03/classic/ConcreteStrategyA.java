package com.anbo.juja.patterns.strategy_03.classic;

/**
 * Created by oleksandr.baglai on 02.09.2015.
 */
public class ConcreteStrategyA implements Strategy {
    @Override
    public Object algorithm(Object input) {
        return String.format("toString:'%s'", input);
    }
}
