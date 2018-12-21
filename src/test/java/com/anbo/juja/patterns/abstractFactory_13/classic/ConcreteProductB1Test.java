package com.anbo.juja.patterns.abstractFactory_13.classic;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by oleksandr.baglai on 11.11.2015.
 */
public class ConcreteProductB1Test {

    @Test
    public void shouldProcess() {
        // given
        Product1 product = new ConcreteProductB1();

        // when
        String result = product.process("data");

        // then
        assertEquals("changedB: data", result);
    }
}
