package com.anbo.juja.patterns.сhain_of_responsibility_07.classic.case4;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by oleksandr.baglai on 30.09.2015.
 */
public class ConcreteHandlerBTest extends ConcreteHandlerTest {

    @Override
    protected Handler getHandler() {
        return new ConcreteHandlerB();
    }

    @Test
    public void shouldCanProcess_whenBoolean() {
        // given
        // String (наш) запрос
        Request request = new Request(new String("request"));

        // when then
        // мы его можем обработать
        assertTrue(handler.canHandle(request));
    }

    @Test
    public void shouldProcess_whenBoolean() {
        // given
        // String (наш) запрос
        Request request = new Request(new String("request"));

        // when
        // отправляем
        handler.handle(request);

        // и при этом напечаталось в консоли
        assertEquals("Request String:request processed by ConcreteHandlerB\n", out.toString());
    }

    @Test
    public void shouldDelegateProcessing_whenNotBoolean() {
        // given
        // Integer (не наш) запрос
        Request request = new Request(new Request(new Integer(24)));

        // when then
        // запрос не может быть обработан
        assertFalse(handler.canHandle(request));

        // дальше ничего больше нет смысла тестить
    }
}
