package com.anbo.juja.patterns.factoryMethod_12.classic.case1_interfaces;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by oleksandr.baglai on 11.11.2015.
 */
public class ConcreteCreatorATest {

    @Test
    public void shouldCreate() {
        // given
        Creator creator = new ConcreteCreatorA();

        // when then
        assertEquals(ConcreteProductA.class,
                creator.factoryMethod().getClass());
    }
}
