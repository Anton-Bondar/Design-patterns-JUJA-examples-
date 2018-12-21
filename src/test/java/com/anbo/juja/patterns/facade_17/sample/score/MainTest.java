package com.anbo.juja.patterns.facade_17.sample.score;

import org.junit.Test;
import ua.com.juja.patterns.facade.ConsoleMock;

import static org.junit.Assert.assertEquals;

/**
 * Created by oleksandr.baglai on 28.12.2015.
 */
public class MainTest {
    ConsoleMock console = new ConsoleMock();

    @Test
    public void test() {
        // when
        Main.main(new String[0]);

        // then
        assertEquals("stiven:118\r\n" +
                "bob:111\r\n" +
                "eva:244\r\n" +
                "TOTAL:473\r\n", console.getOut());
    }
}
