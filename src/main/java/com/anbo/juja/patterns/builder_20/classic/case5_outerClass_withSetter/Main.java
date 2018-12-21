package com.anbo.juja.patterns.builder_20.classic.case5_outerClass_withSetter;

/**
 * Created by oleksandr.baglai on 07.02.2016.
 */
// класс-запускатор
public class Main {

    public static void main(String[] args) {
        // у продукта есть билдер и он объявлен как простой outer class
        // а значит может конструировать продукты на свое усмотрение
        Product object1 =
                Builder.field1("data1")
                        .field2("data2")
                        .field3("data3")
                        .build();
        System.out.println(object1);
        // SomeObject{field1='data1', field2='data2', field3='data3'}

        // тут, заметь мы забыли указать одно поле и оно не за'set'ается
        Product object2 =
                Builder.field1("data1")
                        .field2("data2")
                        .build();
        System.out.println(object2);
        // SomeObject{field1='data1', field2='data2', field3='null'}
    }
}
