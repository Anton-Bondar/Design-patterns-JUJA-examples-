package com.anbo.juja.patterns.adapter_01.adapter6;

/**
 * Created by oleksandr.baglai on 19.08.2015.
 */
public class Adaptee {

    public Object specificRequest(Object input) {
        System.out.println("Call Adaptee.specificRequest(" + input + ")");
        return "Hello from Adaptee!";
    }

}
