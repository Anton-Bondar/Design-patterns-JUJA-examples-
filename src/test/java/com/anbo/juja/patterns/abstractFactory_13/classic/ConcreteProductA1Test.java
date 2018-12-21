package com.anbo.juja.patterns.abstractFactory_13.classic;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by oleksandr.baglai on 11.11.2015.
 */
public class ConcreteProductA1Test {

    @Test
    public void shouldProcess() {
        // given
        Product1 product = new ConcreteProductA1();

        // when
        String result = product.process("data");

        // then
        assertEquals("changedA: data", result);
    }
}
