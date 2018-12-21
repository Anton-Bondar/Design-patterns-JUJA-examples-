package com.anbo.juja.patterns.command_08.classic;

/**
 * Created by oleksandr.baglai on 08.10.2015.
 */
// первый приемник
// по воле случая содержит два полезных метода
public class ReceiverA {
    public Object method1(Object input) {
        return "Processed by ReceiverA in method 1: " + input;
    }

    public Object method2(Object input) {
        return "Processed by ReceiverA in method 2: " + input;
    }
}
