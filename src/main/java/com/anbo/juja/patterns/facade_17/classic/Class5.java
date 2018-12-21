package com.anbo.juja.patterns.facade_17.classic;

/**
 * Created by oleksandr.baglai on 28.12.2015.
 */
public class Class5 {
    public String doSomething(String data) {
        return new Class6(data).doSomething();
    }
}
