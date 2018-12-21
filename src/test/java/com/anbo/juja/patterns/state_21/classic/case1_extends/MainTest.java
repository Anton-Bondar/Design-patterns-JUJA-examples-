package com.anbo.juja.patterns.state_21.classic.case1_extends;

import org.junit.Test;
import ua.com.juja.patterns.objectPool.ConsoleMock;

import static org.junit.Assert.assertEquals;

/**
 * Created by oleksandr.baglai on 24.02.2016.
 */
public class MainTest {
    private ConsoleMock console = new ConsoleMock();

    @Test
    public void test() {
        // when
        Main.main(new String[0]);

        // then
        assertEquals("Set state: A\n" +
                "Handled by A: data1\n" +
                "Set state: B\n" +
                "Handled by B: data2\n" +
                "Set state: C\n" +
                "Handled by C: data3\n" +
                "Set state: A\n" +
                "Handled by A: data4\n" +
                "Set state: B\n" +
                "Handled by B: data5\n" +
                "Set state: C\n", console.getOut());
    }
}
