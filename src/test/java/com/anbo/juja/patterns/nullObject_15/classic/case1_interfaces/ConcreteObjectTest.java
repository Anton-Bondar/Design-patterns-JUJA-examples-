package com.anbo.juja.patterns.nullObject_15.classic.case1_interfaces;

import org.junit.Test;
import ua.com.juja.patterns.nullObject.ConsoleMock;

import static org.junit.Assert.assertEquals;

/**
 * Created by oleksandr.baglai on 10.12.2015.
 */
public class ConcreteObjectTest {

    private ConsoleMock console = new ConsoleMock();

    // так как тестируемый класс печатает в консоль
    // вывод в нее и потестим
    @Test
    public void test() {
        // given
        Abstraction abstraction = new ConcreteObject();

        // when
        abstraction.request("data");

        // then
        assertEquals("data\n", console.getOut());
    }
}
