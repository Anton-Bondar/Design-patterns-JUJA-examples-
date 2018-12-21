package com.anbo.juja.patterns.simpleFactory_14.classic.case1_interface;

/**
 * Created by oleksandr.baglai on 30.11.2015.
 */
// наш клиент
public class Main {

    public static void main(String[] args) {
        Product product = ProductFactory.createProduct("A");
        // Product product = ProductFactory.createProduct("B");

        System.out.println(product.getSomething());
        // вывод:
        //
        // somethingA
        //
        // или
        //
        // somethingB
    }
}
