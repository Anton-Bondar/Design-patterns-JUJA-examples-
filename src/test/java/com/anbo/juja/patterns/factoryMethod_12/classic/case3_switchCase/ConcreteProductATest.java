package com.anbo.juja.patterns.factoryMethod_12.classic.case3_switchCase;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by oleksandr.baglai on 11.11.2015.
 */
public class ConcreteProductATest {

    @Test
    public void shouldProcess() {
        // given
        Product product = new ConcreteProductA();

        // when
        String result = product.process("data");

        // then
        assertEquals("ConcreteProductA: data", result);
    }
}
