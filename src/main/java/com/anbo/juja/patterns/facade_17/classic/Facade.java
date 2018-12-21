package com.anbo.juja.patterns.facade_17.classic;

/**
 * Created by oleksandr.baglai on 28.12.2015.
 */
public class Facade {
    public String doSomething(String data) {
        // прячем вот это все сложное от клиента
        Class5 class5 = new Class5();
        Class2 class2 = new Class2(class5);
        Class4 class4 = new Class4();
        class2.setClass4(class4);
        Class3 class3 = Class3.create();
        Class1 class1 = new Class1(class2, class3);

        return class1.doSomething(data);
    }
}
