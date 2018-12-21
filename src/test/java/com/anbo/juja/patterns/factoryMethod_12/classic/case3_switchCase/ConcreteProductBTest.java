package com.anbo.juja.patterns.factoryMethod_12.classic.case3_switchCase;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by oleksandr.baglai on 11.11.2015.
 */
public class ConcreteProductBTest {

    @Test
    public void shouldProcess() {
        // given
        Product product = new ConcreteProductB();

        // when
        String result = product.process("data");

        // then
        assertEquals("ConcreteProductB: data", result);
    }
}
