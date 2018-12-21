package com.anbo.juja.patterns.factoryMethod_12.classic.case2_abstractClass;

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
        product.setup("config");

        // when
        String result = product.process("data");

        // then
        assertEquals("ConcreteProductA[config]: data", result);
    }
}
