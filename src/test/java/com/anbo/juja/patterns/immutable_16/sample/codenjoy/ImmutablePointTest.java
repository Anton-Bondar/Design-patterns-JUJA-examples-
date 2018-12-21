package com.anbo.juja.patterns.immutable_16.sample.codenjoy;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotSame;
import static org.junit.Assert.*;

public class ImmutablePointTest {

    @Test
    public void shouldSaveXY() {
        ImmutablePoint pt = new ImmutablePoint(10, 12);

        assertEquals(10, pt.getX());
        assertEquals(12, pt.getY());
    }

    @Test
    public void shouldPrintToString() {
        ImmutablePoint pt = new ImmutablePoint(10, 12);

        assertEquals("[10,12]", pt.toString());
    }

    @Test
     public void shouldCopyConstructor() {
        ImmutablePoint pt = new ImmutablePoint(new ImmutablePoint(10, 12));

        assertEquals("[10,12]", pt.toString());
    }

    @Test
    public void shouldItsMe() {
        ImmutablePoint pt = new ImmutablePoint(10, 12);

        assertTrue(pt.itsMe(10, 12));
        assertFalse(pt.itsMe(10 + 1, 12));
        assertFalse(pt.itsMe(10, 12 + 1));

        assertTrue(pt.itsMe(new ImmutablePoint(10, 12)));
        assertFalse(pt.itsMe(new ImmutablePoint(10 + 1, 12)));
        assertFalse(pt.itsMe(new ImmutablePoint(10, 12 + 1)));
    }

    @Test
    public void shouldIsOutOf_byY() {
        ImmutablePoint pt = new ImmutablePoint(10, 12);

        assertTrue(pt.isOutOf(9));
        assertTrue(pt.isOutOf(10));
        assertTrue(pt.isOutOf(11));
        assertTrue(pt.isOutOf(12));
        assertFalse(pt.isOutOf(13));
        assertFalse(pt.isOutOf(14));
    }

    @Test
    public void shouldIsOutOf_byX() {
        ImmutablePoint pt = new ImmutablePoint(12, 10);

        assertTrue(pt.isOutOf(9));
        assertTrue(pt.isOutOf(10));
        assertTrue(pt.isOutOf(11));
        assertTrue(pt.isOutOf(12));
        assertFalse(pt.isOutOf(13));
        assertFalse(pt.isOutOf(14));
    }

    @Test
    public void shouldIsOutOf_byYNegative() {
        ImmutablePoint pt = new ImmutablePoint(10, -12);

        assertTrue(pt.isOutOf(14));
    }

    @Test
    public void shouldIsOutOf_byXNegative() {
        ImmutablePoint pt = new ImmutablePoint(-12, 10);

        assertTrue(pt.isOutOf(14));
    }

    @Test
    public void shouldIsOutOfDelta_from0() {
        ImmutablePoint pt = new ImmutablePoint(1, 5);

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
        ImmutablePoint pt = new ImmutablePoint(10, 15);

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
        ImmutablePoint pt = new ImmutablePoint(10, 15);

        assertEquals(0.0, pt.distance(new ImmutablePoint(10, 15)), 0.0);
        assertEquals(11.180339887498949, pt.distance(new ImmutablePoint(20, 20)), 0.0);
    }

    @Test
    public void shouldEqualsAndHashCode() {
        ImmutablePoint pt = new ImmutablePoint(10, 15);

        assertTrue(pt.equals(new ImmutablePoint(10, 15)));
        assertFalse(pt.equals(new ImmutablePoint(10 + 1, 15)));
        assertFalse(pt.equals(new ImmutablePoint(10, 15 + 1)));
        assertFalse(pt.equals(null));
        assertFalse(pt.equals(new Object()));

        assertEquals(pt.hashCode(), new ImmutablePoint(10, 15).hashCode());
        assertNotSame(pt.hashCode(), new ImmutablePoint(10 + 1, 15).hashCode());
        assertNotSame(pt.hashCode(), new ImmutablePoint(10, 15 + 1).hashCode());
    }

    
    @Test
    public void shouldCopy() {
        ImmutablePoint pt = new ImmutablePoint(10, 15);

        ImmutablePoint pt2 = pt.copy();

        assertNotSame(pt, pt2);
        assertEquals("[10,15]", pt.toString());
        assertEquals("[10,15]", pt2.toString());
    }

    @Test
    public void shouldChange() {
        ImmutablePoint pt = new ImmutablePoint(10, 15);

        ImmutablePoint change = pt.change(new ImmutablePoint(12, -23));

        assertEquals("[10,15]", pt.toString());
        assertEquals("[22,-8]", change.toString());
    }
}
