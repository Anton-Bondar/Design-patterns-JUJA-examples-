package com.anbo.juja.patterns.abstractFactory_13.classic;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by oleksandr.baglai on 11.11.2015.
 */
public class ConcreteFactoryATest {

    @Test
    public void shouldCreate() {
        // given
        AbstractFactory creator = new ConcreteFactoryA();

        // when then
        assertEquals(ConcreteProductA1.class,
                creator.createProduct1().getClass());

        assertEquals(ConcreteProductA2.class,
                creator.createProduct2().getClass());

        assertEquals(ConcreteProductA3.class,
                creator.createProduct3().getClass());
    }
}
