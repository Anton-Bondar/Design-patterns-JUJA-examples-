package com.anbo.juja.patterns.сhain_of_responsibility_07.classic.case4;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by oleksandr.baglai on 30.09.2015.
 */
// Вот если бы все тестирование было таким простым
public class RequestTest {

    @Test
    public void shouldSaveMessage() {
        // given
        Request request = new Request("Какой-то важный запрос!");

        // when
        Object message = request.getMessage();

        // then
        assertEquals("Какой-то важный запрос!", message);
    }

    @Test
    public void shouldToString_whenString() {
        // given
        Request request = new Request("Какой-то важный запрос!");

        // when
        Object message = request.toString();

        // then
        assertEquals("String:Какой-то важный запрос!", message);
    }

    @Test
    public void shouldToString_whenInteger() {
        // given
        Request request = new Request(24);

        // when
        Object message = request.toString();

        // then
        assertEquals("Integer:24", message);
    }
}
