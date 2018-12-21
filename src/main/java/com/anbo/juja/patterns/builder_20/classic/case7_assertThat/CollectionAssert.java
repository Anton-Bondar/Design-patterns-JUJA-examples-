package com.anbo.juja.patterns.builder_20.classic.case7_assertThat;

import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by oleksandr.baglai on 07.02.2016.
 */
// этот набор ассертов умеет работать с Collection
public class CollectionAssert<T> {

    private final Collection<T> actual;

    public CollectionAssert(Collection<T> actual) {
        this.actual = actual;
    }

    public CollectionAssert<T> contains(T object) {
        assertTrue(String.format("'[%s] contains %s' FAILED", actual, object),
                actual.contains(object));
        return this;
    }

    public CollectionAssert<T> doesNotContain(T object) {
        assertFalse(String.format("'[%s] does not contain %s' FAILED", actual, object),
                actual.contains(object));
        return this;
    }

    // другие методы проверок
}
