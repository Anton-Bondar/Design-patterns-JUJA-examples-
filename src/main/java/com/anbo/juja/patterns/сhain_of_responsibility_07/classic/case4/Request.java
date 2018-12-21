package com.anbo.juja.patterns.сhain_of_responsibility_07.classic.case4;

/**
 * Created by oleksandr.baglai on 24.09.2015.
 */
// риквест подозрительно консервативен!
public class Request {
    private Object message;

    public Request(Object message) {
        this.message = message;
    }

    public Object getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return message.getClass().getSimpleName() + ":" + message;
    }
}
