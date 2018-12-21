package com.anbo.juja.patterns.builder_20.classic.case7_assertThat;

import static org.junit.Assert.*;

/**
 * Created by oleksandr.baglai on 07.02.2016.
 */
// этот набор ассертов умеет работать с Integer
public class IntegerAssert {

    private final int actual;

    public IntegerAssert(int actual) {
        this.actual = actual;
    }
    
    public IntegerAssert isMoreThan(int expected) {
        assertTrue(String.format("'%s is more than %s' FAILED", actual, expected),
                actual > expected);
        return this;
    }

    public IntegerAssert isLessThan(int expected) {
        assertTrue(String.format("'%s is less than %s' FAILED", actual, expected),
                actual < expected);
        return this;
    }

    public IntegerAssert inRange(int from, int to) {
        assertTrue(String.format("'%s in range [%s..%s]' FAILED", actual, from, to),
                from <= actual && actual <= to);
        return this;
    }

    public IntegerAssert positive() {
        assertTrue(String.format("'%s in positive' FAILED", actual),
                actual > 0);
        return this;
    }

    // другие методы проверок
}
