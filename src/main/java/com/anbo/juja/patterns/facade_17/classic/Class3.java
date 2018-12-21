package com.anbo.juja.patterns.facade_17.classic;

/**
 * Created by oleksandr.baglai on 28.12.2015.
 */
public class Class3 {

    private Class3() {
        // do nothing
    }

    public static Class3 create() {
        return new Class3();
    }

    public String doSomething(String data) {
        return data;
    }
}
