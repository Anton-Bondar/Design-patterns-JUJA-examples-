package com.anbo.juja.patterns.strategy_03.classic;

/**
 * Created by oleksandr.baglai on 02.09.2015.
 */
public class ConcreteStrategyC implements Strategy {

    @Override
    public Object algorithm(Object input) {
        return String.format("class:%s", input.getClass().getSimpleName());
    }
}
