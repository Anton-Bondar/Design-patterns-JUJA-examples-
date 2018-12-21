package com.anbo.juja.patterns.simpleFactory_14.classic.case2_inheritance;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by oleksandr.baglai on 30.11.2015.
 */
public class ProductFactoryTest {
    @Test
    public void shouldGetProductA() {
        // given
        AbstractProduct product = ProductFactory.createProduct("A");

        // when then
        assertEquals(ConcreteProductA.class, product.getClass());
    }

    @Test
    public void shouldGetProductB() {
        // given
        AbstractProduct product = ProductFactory.createProduct("B");

        // when then
        assertEquals(ConcreteProductB.class, product.getClass());
    }
}
