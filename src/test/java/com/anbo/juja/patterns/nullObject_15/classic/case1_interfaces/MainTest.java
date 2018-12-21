package com.anbo.juja.patterns.nullObject_15.classic.case1_interfaces;

import org.junit.Test;
import ua.com.juja.patterns.nullObject.ConsoleMock;

import static org.junit.Assert.assertEquals;

/**
 * Created by oleksandr.baglai on 10.12.2015.
 */
public class MainTest {

    private ConsoleMock console = new ConsoleMock();

    // так как тестируемый класс печатает в консоль
    // вывод в нее и потестим
    @Test
    public void test() {
        // given when
        Main.main(new String[0]);

        // then
        assertEquals("data_changed\n" +
                "-----------------------\n" +
                "data\n", console.getOut());
    }
}
