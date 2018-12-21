package com.anbo.juja.patterns.visitor_10.sample.garland.element;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by oleksandr.baglai on 23.10.2015.
 */
public class ColorTest {

    @Test
    public void testNext() {
        assertEquals(Color.GREEN, Color.RED.next());
        assertEquals(Color.BLUE, Color.GREEN.next());
        assertEquals(Color.YELLOW, Color.BLUE.next());
        assertEquals(Color.RED, Color.YELLOW.next());
    }
}
