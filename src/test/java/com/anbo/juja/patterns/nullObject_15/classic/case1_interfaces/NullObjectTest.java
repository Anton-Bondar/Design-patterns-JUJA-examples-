package com.anbo.juja.patterns.nullObject_15.classic.case1_interfaces;

import org.junit.Test;
import ua.com.juja.patterns.nullObject.ConsoleMock;

import static org.junit.Assert.assertEquals;

/**
 * Created by oleksandr.baglai on 10.12.2015.
 */
public class NullObjectTest {

    private ConsoleMock console = new ConsoleMock();

    // а тут толком и тестить нечего :)
    @Test
    public void test() {
        // given
        Abstraction abstraction = new NullObject();

        // when
        abstraction.request("data");

        // then
        assertEquals("", console.getOut());
    }
}
