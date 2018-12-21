package com.anbo.juja.patterns.composite_11.classic.case1;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by oleksandr.baglai on 01.11.2015.
 */
public class LeafTest {

    @Test
    public void testOperation1() {
        // given
        Component component = new Leaf("id");

        // when
        String actual = component.operation1("data");

        // then
        assertEquals("id.op1(data)", actual);
    }

    @Test
    public void testOperation2() {
        // given
        Component component = new Leaf("id");

        // when
        String actual = component.operation2("data");

        // then
        assertEquals("id.op2(data)", actual);
    }
}
