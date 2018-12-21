package com.anbo.juja.patterns.adapter_01.adapter2;

/**
 * Created by oleksandr.baglai on 19.08.2015.
 */
public class Client {
    public static void main(String[] args) {
        Target target = new Adapter();
//        Adaptee adaptee = new Adapter();

        doit(target);
    }

    public static void doit(Target target) {
        System.out.println(target.request("Hello World!"));
    }
}
