package com.anbo.juja.patterns.builder_20.classic.case7_assertThat;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;

import static ua.com.juja.patterns.builder.classic.case7_assertThat.Asserts.*;

/**
 * Created by oleksandr.baglai on 07.02.2016.
 */
public class AssertsTest {

    // проверяем все ассерты

    @Test
    public void testBoolean() {
        boolean flag = true;
        assertThat(flag).isTrue();
        assertThat(flag).isNotFalse();

        flag = false;
        assertThat(flag).isFalse();
        assertThat(flag).isNotTrue();
    }

    @Test
    public void testInteger() {
        int number = 13;
        assertThat(number).isMoreThan(10).isLessThan(15).inRange(10, 20).positive();
        assertThat(number).isMoreThan(10);
        assertThat(number).isLessThan(15);
        assertThat(number).inRange(10, 20);
        assertThat(number).positive();
    }

    @Test
    public void testCollection() {
        Collection<String> strings = Arrays.asList("qwe", "asd");
        assertThat(strings).contains("qwe");
        assertThat(strings).doesNotContain("zxc");
    }

    @Test
    public void testAllTogether() {
        boolean flag = true;
        int number = 13;
        Collection<String> strings = Arrays.asList("qwe", "asd");

        assertThat(flag).isTrue().isNotFalse();
        assertThat(number).isMoreThan(10).isLessThan(15).inRange(10, 20).positive();
        assertThat(strings).contains("qwe").doesNotContain("zxc");
    }
}