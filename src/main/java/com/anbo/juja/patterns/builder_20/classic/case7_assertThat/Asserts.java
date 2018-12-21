package com.anbo.juja.patterns.builder_20.classic.case7_assertThat;

import java.util.Collection;

/**
 * Created by oleksandr.baglai on 07.02.2016.
 */
// класс - хранилище статических simple-factory методов
// каждый из которых возвращает свой Assert
public class Asserts {

    public static BooleanAssert assertThat(boolean actual) {
        return new BooleanAssert(actual);
    }

    public static IntegerAssert assertThat(int actual) {
        return new IntegerAssert(actual);
    }

    public static <T> CollectionAssert<T> assertThat(Collection<T> actual) {
        return new CollectionAssert<T>(actual);
    }

}
