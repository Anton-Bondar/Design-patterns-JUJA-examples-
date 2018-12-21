package com.anbo.juja.patterns.facade_17.classic;

/**
 * Created by oleksandr.baglai on 28.12.2015.
 */
public class Class2 {
    private Class4 class4;
    private Class5 class5;

    public Class2(Class5 class5) {
        this.class5 = class5;
    }

    public void setClass4(Class4 class4) {
        this.class4 = class4;
    }

    public String doSomething(String data) {
        return class4.doSomething(class5, data);
    }

}
