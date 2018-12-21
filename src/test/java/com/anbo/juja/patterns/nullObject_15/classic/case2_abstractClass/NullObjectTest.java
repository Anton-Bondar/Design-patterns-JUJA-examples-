package com.anbo.juja.patterns.nullObject_15.classic.case2_abstractClass;

import org.junit.Test;
import ua.com.juja.patterns.nullObject.ConsoleMock;

import static org.junit.Assert.assertEquals;

/**
 * Created by oleksandr.baglai on 10.12.2015.
 */
public class NullObjectTest {

    private ConsoleMock console = new ConsoleMock();

    // тестируем, чтобы ничего не выскочило
    // тест интеграционный, заметь - он тестирует
    // что внутри Client1 NullObject ничего не сделает
    // иначе NullObject сложно потестить, он жеж не делает ничего :)
    @Test
    public void test() {
        // given
        AbstractObject object = new NullObject();
        Client1 client = new Client1(object);

        // when
        client.doSomething("data");

        // then
        assertEquals("", console.getOut());
    }
}
