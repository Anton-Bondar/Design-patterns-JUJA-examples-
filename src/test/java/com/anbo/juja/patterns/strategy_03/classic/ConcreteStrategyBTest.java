package com.anbo.juja.patterns.strategy_03.classic;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by oleksandr.baglai on 02.09.2015.
 */
public class ConcreteStrategyBTest {

    private Strategy strategy = new ConcreteStrategyB();

    @Test
    public void test() {
        assertEquals("length:6", strategy.algorithm("String"));
        assertEquals("length:4", strategy.algorithm(true));
        assertEquals("length:3", strategy.algorithm(7.6));
    }
}
