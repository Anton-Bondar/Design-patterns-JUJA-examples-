package com.anbo.juja.patterns.nullObject_15.classic.case2_abstractClass;

/**
 * Created by oleksandr.baglai on 09.12.2015.
 */
// это наша абстракиця
public abstract class AbstractObject {

    // разные недореализованные методы
    // принимающий на выход
    public abstract void request1(String input);

    // только тдающий
    public abstract String request2();

    // без параметров
    public abstract void request3();

    // с двумя параметрами
    public abstract void request4(String input1, String input2);

    // и даже реализованный
    public String request5(String input) {
        return input + "_changed";
    }

    // какие угодно!
}
