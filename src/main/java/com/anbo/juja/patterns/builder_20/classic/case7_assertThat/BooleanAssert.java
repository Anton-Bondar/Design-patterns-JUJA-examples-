package com.anbo.juja.patterns.builder_20.classic.case7_assertThat;

import static org.junit.Assert.*;

/**
 * Created by oleksandr.baglai on 07.02.2016.
 */
// этот набор ассертов умеет работать с boolean
public class BooleanAssert {

    // что валидируем
    // в мире junit оно называется actual
    // а то, с чем сравниваем - expected
    private final boolean actual;

    public BooleanAssert(boolean actual) {
        this.actual = actual;
    }

    public BooleanAssert isTrue() {
        assertEquals(true, actual);

        // заметь тут как в нашем билдере
        // чтобы можно было делать так
        // assertThat(flag).isTrue().isNotFalse();
        return this;
    }

    public BooleanAssert isNotFalse() {
        isTrue();
        return this;
    }

    public BooleanAssert isFalse() {
        assertEquals(false, actual);
        return this;
    }

    public BooleanAssert isNotTrue() {
        isFalse();
        return this;
    }

    // другие методы проверок
}
