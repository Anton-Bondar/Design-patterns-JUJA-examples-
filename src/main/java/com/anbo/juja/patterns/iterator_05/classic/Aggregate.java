package com.anbo.juja.patterns.iterator_05.classic;

/**
 * Created by oleksandr.baglai on 16.09.2015.
 */
public interface Aggregate<T> {

    Iterator<T> createIterator();
}
