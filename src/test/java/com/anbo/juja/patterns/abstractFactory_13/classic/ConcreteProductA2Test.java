package com.anbo.juja.patterns.abstractFactory_13.classic;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by oleksandr.baglai on 11.11.2015.
 */
public class ConcreteProductA2Test {

    @Test
    public void shouldSet() {
        // given
        Product2 product = new ConcreteProductA2();

        // when
        product.setOne("one");
        product.setAnother("another");

        // then
        assertEquals("printedA: one-another", product.toString());
    }
}
