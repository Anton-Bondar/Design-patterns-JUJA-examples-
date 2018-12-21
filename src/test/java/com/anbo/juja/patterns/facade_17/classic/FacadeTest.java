package com.anbo.juja.patterns.facade_17.classic;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by oleksandr.baglai on 28.12.2015.
 */
public class FacadeTest {

    @Test
    public void test() {
        // given
        Facade facade = new Facade();

        // when
        String result = facade.doSomething("data");

        // then
        assertEquals("datadata", result);
    }
}
