package com.anbo.juja.patterns.simpleFactory_14.classic.case2_inheritance;

/**
 * Created by oleksandr.baglai on 30.11.2015.
 */
// наш клиент
public class Main {

    public static void main(String[] args) {
        AbstractProduct product = ProductFactory.createProduct("A");
        // AbstractProduct product = ProductFactory.createProduct("B");

        System.out.println(product.getSomething());
        // вывод:
        //
        // common_somethingA
        //
        // или
        //
        // somethingB_common
    }
}
