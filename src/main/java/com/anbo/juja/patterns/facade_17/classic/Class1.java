package com.anbo.juja.patterns.facade_17.classic;

/**
 * Created by oleksandr.baglai on 28.12.2015.
 */
public class Class1 {

    private final Class2 class2;
    private final Class3 class3;

    public Class1(Class2 class2, Class3 class3) {
        this.class2 = class2;
        this.class3 = class3;
    }

    public String doSomething(String data) {
        return class2.doSomething(data) + class3.doSomething(data);
    }
}
