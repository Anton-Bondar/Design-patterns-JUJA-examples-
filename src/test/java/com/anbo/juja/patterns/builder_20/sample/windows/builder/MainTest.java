package com.anbo.juja.patterns.builder_20.sample.windows.builder;

import org.junit.Test;
import ua.com.juja.patterns.objectPool.ConsoleMock;

import static org.junit.Assert.assertEquals;

/**
 * Created by oleksandr.baglai on 10.02.2016.
 */
// тест для галочки :)
public class MainTest {

    public ConsoleMock console = new ConsoleMock();

    @Test
    public void test() {
        // when
        Main.main(new String[0]);

        // when
        assertEquals(
                "┌───────────────────────────────┐\n" +
                "│┌───┐┌─────────┐┌────┐┌───────┐│\n" +
                "││one││┌───┐    ││four││┌───┐  ││\n" +
                "│└───┘││two│    │└────┘││six│  ││\n" +
                "│     │└───┘    │      │└───┘  ││\n" +
                "│     │┌─────┐  │      │┌─────┐││\n" +
                "│     ││three│  │      ││seven│││\n" +
                "│     │└─────┘  │      │└─────┘││\n" +
                "│     │┌────┐   │      └───────┘│\n" +
                "│     ││five│   │               │\n" +
                "│     │└────┘   │               │\n" +
                "│     │┌───────┐│               │\n" +
                "│     ││┌─────┐││               │\n" +
                "│     │││eight│││               │\n" +
                "│     ││└─────┘││               │\n" +
                "│     │└───────┘│               │\n" +
                "│     └─────────┘               │\n" +
                "└───────────────────────────────┘\n", console.getOut());
    }
}
