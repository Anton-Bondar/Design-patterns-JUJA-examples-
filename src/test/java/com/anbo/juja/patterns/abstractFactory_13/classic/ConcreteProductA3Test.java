package com.anbo.juja.patterns.abstractFactory_13.classic;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by oleksandr.baglai on 11.11.2015.
 */
public class ConcreteProductA3Test {

    @Test
    public void shouldSet() {
        // given
        Product3 product = new ConcreteProductA3();

        // when then
        assertEquals("oneA", product.getOne());
        assertEquals("anotherA", product.getAnother());
        assertEquals("somethingA", product.getSomething());
    }
}
