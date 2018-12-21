package com.anbo.juja.patterns.command_08.classic;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by oleksandr.baglai on 08.10.2015.
 */
public class ReceiverATest {

    // given
    private ReceiverA receiver = new ReceiverA();

    @Test
    public void testMethod1() {
        // when then
        assertEquals("Processed by ReceiverA in method 1: data1",
                receiver.method1("data1"));
    }

    @Test
    public void testMethod2() {
        // when then
        assertEquals("Processed by ReceiverA in method 2: data2",
                receiver.method2("data2"));

    }
}
