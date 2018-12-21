package com.anbo.juja.patterns.adapter_01.adapter3;

/**
 * Created by oleksandr.baglai on 19.08.2015.
 */
public class Adapter extends Target {

    private Adaptee adaptee;

    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public Object request(Object input) {
        return adaptee.specificRequest(input);
    }
}
