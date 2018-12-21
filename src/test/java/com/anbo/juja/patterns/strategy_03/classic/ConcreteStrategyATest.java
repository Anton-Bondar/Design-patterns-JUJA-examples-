package com.anbo.juja.patterns.strategy_03.classic;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by oleksandr.baglai on 02.09.2015.
 */
public class ConcreteStrategyATest {

    private Strategy strategy = new ConcreteStrategyA();

    @Test
    public void test() {
        assertEquals("toString:'String'", strategy.algorithm("String"));
        assertEquals("toString:'true'", strategy.algorithm(true));
        assertEquals("toString:'7.6'", strategy.algorithm(7.6));
    }
}
