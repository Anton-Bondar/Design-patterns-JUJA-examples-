package com.anbo.juja.patterns.command_08.classic;

import org.junit.Test;
import ua.com.juja.patterns.command.ConsoleMock;

import static org.junit.Assert.assertEquals;

/**
 * Created by oleksandr.baglai on 08.10.2015.
 */
public class ReceiverBTest {

    private ConsoleMock console = new ConsoleMock();

    @Test
    public void testOtherMethod() {
        // given
        ReceiverB receiver = new ReceiverB();

        // when
        receiver.otherMethod("data");

        // then
        assertEquals("ReceiverB got a: data\r\n",
                console.getOut());
    }
}
