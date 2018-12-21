package com.anbo.juja.patterns.сhain_of_responsibility_07.classic.case2;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Created by oleksandr.baglai on 30.09.2015.
 */
// тут все так же как и в ConcreteHandlerATest
// ну почти... там жеж бага была
public class BrokenHandlerDTest extends ConcreteHandlerTest {

    @Override
    protected Handler getHandler() {
        return new BrokenHandlerD();
    }

    @Test
    public void shouldProcess_whenCharacter() {
        // when
        // отправляем Character (наш) запрос
        handler.handleRequest(new Request(new Character('!')));

        // then
        // видим что сигнал не пошел дальше
        assertNull(processed);

        // и при этом напечаталось в консоли
        assertEquals("Request Character:! processed by BrokenHandlerD\n", out.toString());
    }

    @Test
    public void shouldDelegateProcessing_whenNotCharacter() {
        // тут у нас уже все настроено в методе setup()

        // when
        // отправляем String (не наш) запрос
        handler.handleRequest(new Request(new String("!")));

        // then
        // запрос не пошел дальше, а должен был
        // assertEquals("!", processed.getMessage()); TODO исправить!
        assertNull(processed);

        // а консоль пуста
        assertEquals("", out.toString());
    }
}
