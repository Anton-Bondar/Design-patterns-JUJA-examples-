package com.anbo.juja.patterns.builder_20.classic.case0_classic;

/**
 * Created by oleksandr.baglai on 07.02.2016.
 */
// класс-запускатор
// спасибо за статью https://www.noppanit.com/java-builder-pattern-want-to-avoid-getters-and-setters/
public class Main {

    public static void main(String[] args) {
        // создаем билдер и дирижера-директора (называй как нравится)
        Builder builder = new ConcreteBuilder();
        Director director = new Director(builder);

        // собираем объект
        director.construct();

        // получаем объект
        Product product = director.getProduct();

        // ну и на экран выводим
        System.out.println(product);
        // SomeObject{field1='data1', field2='data2', field3='data3'}
    }
}
