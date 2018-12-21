package com.anbo.juja.patterns.simpleFactory_14.classic.case2_inheritance;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by oleksandr.baglai on 30.11.2015.
 */
public class ConcreteProductBTest {
    @Test
    public void shouldGetSomething() {
        // given
        AbstractProduct product = new ConcreteProductB();

        // when
        String something = product.getSomething();

        // then
        assertEquals("somethingB_common", something);
    }
}
