package com.anbo.juja.patterns.nullObject_15.classic.case2_abstractClass;

import org.junit.Test;
import ua.com.juja.patterns.nullObject.ConsoleMock;

import static org.junit.Assert.assertEquals;

/**
 * Created by oleksandr.baglai on 10.12.2015.
 */
// потестим еще и Main-запускатор на всякий :)
public class MainTest {

    private ConsoleMock console = new ConsoleMock();

    @Test
    public void test() {
        // given when
        Main.main(new String[0]);

        // then
        assertEquals("request1('data')\n" +
                "request2() = result2\n" +
                "request3()\n" +
                "request4('data', 'result2')\n" +
                "result2data_changed\n" +
                "-----------------------\n" +
                "request1('data')\n" +
                "request2() = result2\n" +
                "request3()\n" +
                "request4('data', 'result2')\n" +
                "result2data_changed", console.getOut());
    }
}
