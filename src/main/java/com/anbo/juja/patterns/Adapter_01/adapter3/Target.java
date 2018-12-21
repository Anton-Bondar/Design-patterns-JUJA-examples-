package com.anbo.juja.patterns.adapter_01.adapter3;

/**
 * Created by oleksandr.baglai on 19.08.2015.
 */
public class Target {

    public Object request(Object input) {
        System.out.println("Call Target.request(" + input + ")");
        return "Hello from Target!";
    }

}
