package com.anbo.juja.patterns.factoryMethod_12.classic.case2_abstractClass;

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
        product.setup("config");

        // when
        String result = product.process("data");

        // then
        assertEquals("ConcreteProductB[config]: data", result);
    }
}
