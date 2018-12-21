package com.anbo.juja.patterns.adapter_01.adapter5;

/**
 * Created by oleksandr.baglai on 19.08.2015.
 */
public class Client {
    public static void main(String[] args) {
        final Adaptee adaptee = new Adaptee();

        Target target = new Target() {
            public Object request(Object input) {
                return adaptee.specificRequest(input);
            }
        };

        doit(target);
    }

    public static void doit(Target target) {
        System.out.println(target.request("Hello World!"));
    }
}
