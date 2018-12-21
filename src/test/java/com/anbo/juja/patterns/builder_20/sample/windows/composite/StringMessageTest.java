package com.anbo.juja.patterns.builder_20.sample.windows.composite;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by oleksandr.baglai on 27.10.2015.
 */
public class StringMessageTest {

    @Test
    public void testDraw() {
        // given
        Window window = new StringMessage("message");

        // when
        String draw = window.draw();

        // then
        assertEquals(
                "┌───────┐\n" +
                "│message│\n" +
                "└───────┘\n", draw);
    }

    @Test
    public void testSize() {
        // given
        Window window = new StringMessage("message");

        // when then
        assertEquals(9, window.width());
        assertEquals(3, window.height());
    }
}
