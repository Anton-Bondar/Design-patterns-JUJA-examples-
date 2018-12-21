package com.anbo.juja.patterns.nullObject_15.classic.case2_abstractClass;

import org.junit.Test;
import ua.com.juja.patterns.nullObject.ConsoleMock;

import static org.junit.Assert.assertEquals;

/**
 * Created by oleksandr.baglai on 10.12.2015.
 */
// потестим каждый метод реального объекта отдельно
public class ConcreteObjectTest {

    private ConsoleMock console = new ConsoleMock();

    @Test
    public void testRequest1() {
        // given
        AbstractObject object = new ConcreteObject();

        // when
        object.request1("data");

        // then
        assertEquals("request1('data')\n", console.getOut());
    }

    @Test
    public void testRequest2() {
        // given
        AbstractObject object = new ConcreteObject();

        // when
        String result = object.request2();

        // then
        assertEquals("result2", result);
        assertEquals("request2() = result2\n", console.getOut());
    }

    @Test
    public void testRequest3() {
        // given
        AbstractObject object = new ConcreteObject();

        // when
        object.request3();

        // then
        assertEquals("request3()\n", console.getOut());
    }

    @Test
    public void testRequest4() {
        // given
        AbstractObject object = new ConcreteObject();

        // when
        object.request4("data1", "data2");

        // then
        assertEquals("request4('data1', 'data2')\n", console.getOut());
    }

    @Test
    public void testRequest5() {
        // given
        AbstractObject object = new ConcreteObject();

        // when
        String result = object.request5("data");

        // then
        assertEquals("data_changed", result);
        assertEquals("", console.getOut());
    }
}
