package com.anbo.juja.patterns.immutable_16.sample.codenjoy;

import junit.framework.Assert;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;

public class PointTest {

    @Test
    public void shouldSaveXY() {
        Point pt = new Point(10, 12);

        assertEquals(10, pt.getX());
        assertEquals(12, pt.getY());
    }

    @Test
    public void shouldPrintToString() {
        Point pt = new Point(10, 12);

        assertEquals("[10,12]", pt.toString());
    }

    @Test
     public void shouldCopyConstructor() {
        Point pt = new Point(new Point(10, 12));

        assertEquals("[10,12]", pt.toString());
    }

    @Test
    public void shouldItsMe() {
        Point pt = new Point(10, 12);

        assertTrue(pt.itsMe(10, 12));
        assertFalse(pt.itsMe(10 + 1, 12));
        assertFalse(pt.itsMe(10, 12 + 1));

        assertTrue(pt.itsMe(new Point(10, 12)));
        assertFalse(pt.itsMe(new Point(10 + 1, 12)));
        assertFalse(pt.itsMe(new Point(10, 12 + 1)));
    }

    @Test
    public void shouldIsOutOf_byY() {
        Point pt = new Point(10, 12);

        assertTrue(pt.isOutOf(9));
        assertTrue(pt.isOutOf(10));
        assertTrue(pt.isOutOf(11));
        assertTrue(pt.isOutOf(12));
        assertFalse(pt.isOutOf(13));
        assertFalse(pt.isOutOf(14));
    }

    @Test
    public void shouldIsOutOf_byX() {
        Point pt = new Point(12, 10);

        assertTrue(pt.isOutOf(9));
        assertTrue(pt.isOutOf(10));
        assertTrue(pt.isOutOf(11));
        assertTrue(pt.isOutOf(12));
        assertFalse(pt.isOutOf(13));
        assertFalse(pt.isOutOf(14));
    }

    @Test
    public void shouldIsOutOf_byYNegative() {
        Point pt = new Point(10, -12);

        assertTrue(pt.isOutOf(14));
    }

    @Test
    public void shouldIsOutOf_byXNegative() {
        Point pt = new Point(-12, 10);

        assertTrue(pt.isOutOf(14));
    }

    @Test
    public void shouldIsOutOfDelta_from0() {
        Point pt = new Point(1, 5);

        assertFalse(pt.isOutOf(0, 0, 20));
        assertFalse(pt.isOutOf(1, 0, 20));
        assertTrue(pt.isOutOf(2, 0, 20));
        assertTrue(pt.isOutOf(3, 0, 20));

        assertFalse(pt.isOutOf(0, 0, 20));
        assertFalse(pt.isOutOf(0, 1, 20));
        assertFalse(pt.isOutOf(0, 2, 20));
        assertFalse(pt.isOutOf(0, 3, 20));
        assertFalse(pt.isOutOf(0, 4, 20));
        assertFalse(pt.isOutOf(0, 5, 20));
        assertTrue(pt.isOutOf(0, 6, 20));
        assertTrue(pt.isOutOf(0, 7, 20));
    }

    @Test
    public void shouldIsOutOfDelta_fromSize() {
        Point pt = new Point(10, 15);

        assertFalse(pt.isOutOf(0, 0, 20));
        assertFalse(pt.isOutOf(0, 1, 20));
        assertFalse(pt.isOutOf(0, 2, 20));
        assertFalse(pt.isOutOf(0, 3, 20));
        assertFalse(pt.isOutOf(0, 4, 20));
        assertTrue(pt.isOutOf(0, 5, 20));
        assertTrue(pt.isOutOf(0, 6, 20));
        assertTrue(pt.isOutOf(0, 7, 20));

        assertFalse(pt.isOutOf(8, 0, 20));
        assertFalse(pt.isOutOf(9, 0, 20));
        assertTrue(pt.isOutOf(10, 0, 20));
        assertTrue(pt.isOutOf(11, 0, 20));
    }

    @Test
    public void shouldDistance() {
        Point pt = new Point(10, 15);

        assertEquals(0.0, pt.distance(new Point(10, 15)));
        assertEquals(11.180339887498949, pt.distance(new Point(20, 20)));
    }

    @Test
    public void shouldEqualsAndHashCode() {
        Point pt = new Point(10, 15);

        assertTrue(pt.equals(new Point(10, 15)));
        assertFalse(pt.equals(new Point(10 + 1, 15)));
        assertFalse(pt.equals(new Point(10, 15 + 1)));
        assertFalse(pt.equals(null));
        assertFalse(pt.equals(new Object()));

        assertEquals(pt.hashCode(), new Point(10, 15).hashCode());
        assertNotSame(pt.hashCode(), new Point(10 + 1, 15).hashCode());
        assertNotSame(pt.hashCode(), new Point(10, 15 + 1).hashCode());
    }

    @Test
    public void shouldMove() {
        Point pt = new Point(10, 15);

        pt.move(new Point(20, 23));

        assertEquals("[20,23]", pt.toString());

        pt.move(40, 43);

        assertEquals("[40,43]", pt.toString());
    }

    @Test
    public void shouldCopy() {
        Point pt = new Point(10, 15);

        Point pt2 = pt.copy();
        pt.move(1, 2);

        assertEquals("[1,2]", pt.toString());
        assertEquals("[10,15]", pt2.toString());
    }

    @Test
    public void shouldChange() {
        Point pt = new Point(10, 15);

        pt.change(new Point(12, -23));

        assertEquals("[22,-8]", pt.toString());
    }
}
