package com.anbo.juja.patterns.simpleFactory_14.classic.case2_inheritance;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by oleksandr.baglai on 30.11.2015.
 */
public class ConcreteProductATest {
    @Test
    public void shouldGetSomething() {
        // given
        AbstractProduct product = new ConcreteProductA();

        // when
        String something = product.getSomething();

        // then
        assertEquals("common_somethingA", something);
    }
}
