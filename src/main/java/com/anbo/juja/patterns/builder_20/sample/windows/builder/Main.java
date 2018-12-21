package com.anbo.juja.patterns.builder_20.sample.windows.builder;

import ua.com.juja.patterns.builder.sample.windows.composite.Window;

import static ua.com.juja.patterns.builder.sample.windows.builder.WindowBuilder.window;

/**
 * Created by oleksandr.baglai on 10.02.2016.
 */
public class Main {

    // помнишь как в шаблоне Composite неуклюже выглядел
    // метод построения структуры окон?
    // public static void main(String[] args) {
    //     Window root = new HorizontalAlignment();
    //
    //     root.add(new StringMessage("one"));
    //
    //     Window composite2 = new VerticalAlignment();
    //     root.add(composite2);
    //
    //     composite2.add(new StringMessage("two"));
    //     composite2.add(new StringMessage("three"));
    //
    //     root.add(new StringMessage("four"));
    //     composite2.add(new StringMessage("five"));
    //
    //     Window composite3 = new VerticalAlignment();
    //     root.add(composite3);
    //
    //     composite3.add(new StringMessage("six"));
    //     composite3.add(new StringMessage("seven"));
    //
    //     Window composite4 = new VerticalAlignment();
    //     composite2.add(composite4);
    //
    //     composite4.add(new StringMessage("eight"));
    //
    //     System.out.println(root.draw());
    // }

    // а теперь поросим сделать это билдера
    public static void main(String[] args) {
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

        // правда нагляднее?!

        System.out.print(root.draw());

        // вывод:
        // ┌───────────────────────────────┐
        // │┌───┐┌─────────┐┌────┐┌───────┐│
        // ││one││┌───┐    ││four││┌───┐  ││
        // │└───┘││two│    │└────┘││six│  ││
        // │     │└───┘    │      │└───┘  ││
        // │     │┌─────┐  │      │┌─────┐││
        // │     ││three│  │      ││seven│││
        // │     │└─────┘  │      │└─────┘││
        // │     │┌────┐   │      └───────┘│
        // │     ││five│   │               │
        // │     │└────┘   │               │
        // │     │┌───────┐│               │
        // │     ││┌─────┐││               │
        // │     │││eight│││               │
        // │     ││└─────┘││               │
        // │     │└───────┘│               │
        // │     └─────────┘               │
        // └───────────────────────────────┘
    }

}
