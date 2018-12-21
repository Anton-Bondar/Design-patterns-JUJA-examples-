package com.anbo.juja.patterns.abstractFactory_13.classic;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by oleksandr.baglai on 11.11.2015.
 */
public class ConcreteFactoryBTest {

    @Test
    public void shouldCreate() {
        // given
        AbstractFactory creator = new ConcreteFactoryB();

        // when then
        assertEquals(ConcreteProductB1.class,
                creator.createProduct1().getClass());

        assertEquals(ConcreteProductB2.class,
                creator.createProduct2().getClass());

        assertEquals(ConcreteProductB3.class,
                creator.createProduct3().getClass());
    }
}
