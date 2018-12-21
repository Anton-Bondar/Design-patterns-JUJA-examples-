package com.anbo.juja.patterns.strategy_03.classic;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by oleksandr.baglai on 02.09.2015.
 */
public class ContextTest {

    @Test
    public void testConstructorInjection() {
        // given
        Context context = new Context(new Strategy() {
            @Override
            public Object algorithm(Object input) {
                return input.toString().toUpperCase();
            }
        });

        // when
        Object actual = context.method("qwe");

        // then
        assertEquals("Object: qwe, QWE", actual);
    }
}
