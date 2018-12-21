package com.anbo.juja.patterns.abstractFactory_13.classic;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by oleksandr.baglai on 11.11.2015.
 */
public class ConcreteProductB3Test {

    @Test
    public void shouldSet() {
        // given
        Product3 product = new ConcreteProductB3();

        // when then
        assertEquals("oneB", product.getOne());
        assertEquals("anotherB", product.getAnother());
        assertEquals("somethingB", product.getSomething());
    }
}
