package com.anbo.juja.patterns.factoryMethod_12.classic.case2_abstractClass;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by oleksandr.baglai on 11.11.2015.
 */
public class ConcreteCreatorBTest {

    @Test
    public void shouldCreate() {
        // given
        Creator creator = new ConcreteCreatorB();

        // when then
        assertEquals(ConcreteProductB.class,
                creator.factoryMethod().getClass());
    }
}
