package com.anbo.juja.patterns.adapter_01.adapter3;

/**
 * Created by oleksandr.baglai on 19.08.2015.
 */
public class Client {
    public static void main(String[] args) {
        Adaptee adaptee = new Adaptee();

        Target target = new Adapter(adaptee);

        doit(target);
    }

    public static void doit(Target target) {
        System.out.println(target.request("Hello World!"));
    }
}
