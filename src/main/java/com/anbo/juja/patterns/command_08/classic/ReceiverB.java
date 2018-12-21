package com.anbo.juja.patterns.command_08.classic;

/**
 * Created by oleksandr.baglai on 08.10.2015.
 */
// второй приемник c одним единственным методом
public class ReceiverB {

    public void otherMethod(Object input) {
        System.out.println("ReceiverB got a: " + input);
    }
}
