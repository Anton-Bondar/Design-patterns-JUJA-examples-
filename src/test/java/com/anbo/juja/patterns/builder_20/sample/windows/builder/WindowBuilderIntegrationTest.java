package com.anbo.juja.patterns.builder_20.sample.windows.builder;

import org.junit.Test;
import ua.com.juja.patterns.builder.sample.windows.composite.Window;

import static org.junit.Assert.assertEquals;
import static ua.com.juja.patterns.builder.sample.windows.builder.WindowBuilder.window;

// интеграционные тесты, тестирую билдер вместе с пакетом windows.composite
// это нагляднее, но тесты зависимы на два пакета
public class WindowBuilderIntegrationTest {

    @Test
    public void test1() {
        // given
        Window root =
                window().add(
                        window("one"),
                        window().add(
                                window("two"),
                                window("three"),
                                window("five"),
                                window().add(
                                        window("eight")
                                )
                        ).vertical(),
                        window("four"),
                        window().add(
                                window("six"),
                                window("seven")
                        ).vertical()
                ).horizontal().build();

        // when
        String draw = root.draw();

        // then
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
                "└───────────────────────────────┘\n", draw);
    }

    @Test
    public void test2() {
        // given
        Window root =
                window().add(
                        window("one"),
                        window().add(
                                window("two"),
                                window("three"),
                                window("five"),
                                window().add(
                                        window("eight")
                                )
                        ).horizontal(),
                        window("four"),
                        window().add(
                                window("six"),
                                window("seven")
                        ).horizontal()
                ).vertical().build();

        // when
        String draw = root.draw();

        // when
        assertEquals(
                "┌─────────────────────────────┐\n" +
                "│┌───┐                        │\n" +
                "││one│                        │\n" +
                "│└───┘                        │\n" +
                "│┌───────────────────────────┐│\n" +
                "││┌───┐┌─────┐┌────┐┌───────┐││\n" +
                "│││two││three││five││┌─────┐│││\n" +
                "││└───┘└─────┘└────┘││eight││││\n" +
                "││                  │└─────┘│││\n" +
                "││                  └───────┘││\n" +
                "│└───────────────────────────┘│\n" +
                "│┌────┐                       │\n" +
                "││four│                       │\n" +
                "│└────┘                       │\n" +
                "│┌────────────┐               │\n" +
                "││┌───┐┌─────┐│               │\n" +
                "│││six││seven││               │\n" +
                "││└───┘└─────┘│               │\n" +
                "│└────────────┘               │\n" +
                "└─────────────────────────────┘\n", draw);

    }

    @Test
    public void test3() {
        // given
        Window root =
                window().add(
                        window("one"),
                        window().add(
                                window("two"),
                                window("three"),
                                window("five"),
                                window().add(
                                        window("eight")
                                )
                        ).vertical(),
                        window("four"),
                        window().add(
                                window("six"),
                                window("seven")
                        ).vertical()
                ).vertical().build();

        // when
        String draw = root.draw();

        // when
        assertEquals(
                "┌───────────┐\n" +
                "│┌───┐      │\n" +
                "││one│      │\n" +
                "│└───┘      │\n" +
                "│┌─────────┐│\n" +
                "││┌───┐    ││\n" +
                "│││two│    ││\n" +
                "││└───┘    ││\n" +
                "││┌─────┐  ││\n" +
                "│││three│  ││\n" +
                "││└─────┘  ││\n" +
                "││┌────┐   ││\n" +
                "│││five│   ││\n" +
                "││└────┘   ││\n" +
                "││┌───────┐││\n" +
                "│││┌─────┐│││\n" +
                "││││eight││││\n" +
                "│││└─────┘│││\n" +
                "││└───────┘││\n" +
                "│└─────────┘│\n" +
                "│┌────┐     │\n" +
                "││four│     │\n" +
                "│└────┘     │\n" +
                "│┌───────┐  │\n" +
                "││┌───┐  │  │\n" +
                "│││six│  │  │\n" +
                "││└───┘  │  │\n" +
                "││┌─────┐│  │\n" +
                "│││seven││  │\n" +
                "││└─────┘│  │\n" +
                "│└───────┘  │\n" +
                "└───────────┘\n", draw);
    }

    @Test
    public void test4() {
        // given
        Window root =
                window().add(
                        window("one"),
                        window().add(
                                window("two"),
                                window("three"),
                                window("five"),
                                window().add(
                                        window("eight")
                                )
                        ).horizontal(),
                        window("four"),
                        window().add(
                                window("six"),
                                window("seven")
                        ).horizontal()
                ).horizontal().build();

        // when
        String draw = root.draw();

        // when
        assertEquals(
                "┌──────────────────────────────────────────────────────┐\n" +
                "│┌───┐┌───────────────────────────┐┌────┐┌────────────┐│\n" +
                "││one││┌───┐┌─────┐┌────┐┌───────┐││four││┌───┐┌─────┐││\n" +
                "│└───┘││two││three││five││┌─────┐││└────┘││six││seven│││\n" +
                "│     │└───┘└─────┘└────┘││eight│││      │└───┘└─────┘││\n" +
                "│     │                  │└─────┘││      └────────────┘│\n" +
                "│     │                  └───────┘│                    │\n" +
                "│     └───────────────────────────┘                    │\n" +
                "└──────────────────────────────────────────────────────┘\n", draw);

    }
}
