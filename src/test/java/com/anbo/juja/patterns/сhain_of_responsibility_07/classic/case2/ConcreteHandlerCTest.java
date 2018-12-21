package com.anbo.juja.patterns.сhain_of_responsibility_07.classic.case2;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Created by oleksandr.baglai on 30.09.2015.
 */
// тут все так же как и в ConcreteHandlerATest
public class ConcreteHandlerCTest extends ConcreteHandlerTest {

    @Override
    protected Handler getHandler() {
        return new ConcreteHandlerC();
    }

    @Test
    public void shouldProcess_whenInteger() {
        // when
        // отправляем Integer (наш) запрос
        handler.handleRequest(new Request(new Integer(24)));

        // then
        // видим что сигнал не пошел дальше
        assertNull(processed);

        // и при этом напечаталось в консоли
        assertEquals("Request Integer:24 processed by ConcreteHandlerC\n", out.toString());
    }

    @Test
    public void shouldDelegateProcessing_whenNotInteger() {
        // тут у нас уже все настроено в методе setup()

        // when
        // отправляем String (не наш) запрос
        handler.handleRequest(new Request(new String("24")));

        // then
        // запрос пошел дальше
        assertEquals("24", processed.getMessage());

        // а консоль пуста
        assertEquals("", out.toString());
    }
}
