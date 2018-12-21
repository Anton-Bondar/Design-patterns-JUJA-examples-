package com.anbo.juja.patterns.simpleFactory_14.classic.case1_interface;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by oleksandr.baglai on 30.11.2015.
 */
public class ProductFactoryTest {
    @Test
    public void shouldGetProductA() {
        // given
        Product product = ProductFactory.createProduct("A");

        // when then
        assertEquals(ConcreteProductA.class, product.getClass());
    }

    @Test
    public void shouldGetProductB() {
        // given
        Product product = ProductFactory.createProduct("B");

        // when then
        assertEquals(ConcreteProductB.class, product.getClass());
    }
}
