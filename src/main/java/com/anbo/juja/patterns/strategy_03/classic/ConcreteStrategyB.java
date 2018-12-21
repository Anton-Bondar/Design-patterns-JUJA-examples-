package com.anbo.juja.patterns.strategy_03.classic;

/**
 * Created by oleksandr.baglai on 02.09.2015.
 */
public class ConcreteStrategyB implements Strategy {
    @Override
    public Object algorithm(Object input) {
        return String.format("length:%s", input.toString().length());
    }
}
