package com.anbo.juja.patterns.simpleFactory_14.classic.case2_inheritance;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by oleksandr.baglai on 30.11.2015.
 */
public class AbstractProductTest {
    @Test
    public void shouldGetCommon() {
        // given
        AbstractProduct product = new AbstractProduct() {
            @Override
            String getSomething() {
                return null;
            }
        };

        // when
        String string = product.somethingCommon();

        // then
        assertEquals("common", string);
    }
}
