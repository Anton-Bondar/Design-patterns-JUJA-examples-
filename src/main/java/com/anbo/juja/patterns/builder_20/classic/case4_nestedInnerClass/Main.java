package com.anbo.juja.patterns.builder_20.classic.case4_nestedInnerClass;


/**
 * Created by oleksandr.baglai on 07.02.2016.
 */
// класс-запускатор
// за пример спасибо https://habrahabr.ru/post/244521/
public class Main {

    public static void main(String[] args) {
        // у продукта есть билдер и он объявлен как inner nested class
        // а значит может конструировать продукты на свое усмотрение
        Product object = new Product.Builder()
                .field1("data1")
                .field2("data2")
                .field3("data3")
                .build();

        System.out.println(object);
        // SomeObject{field1='data1', field2='data2', field3='data3'}
    }
}
