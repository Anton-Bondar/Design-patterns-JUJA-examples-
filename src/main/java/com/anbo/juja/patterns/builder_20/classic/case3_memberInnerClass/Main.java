package com.anbo.juja.patterns.builder_20.classic.case3_memberInnerClass;


/**
 * Created by oleksandr.baglai on 07.02.2016.
 */
// класс-запускатор
public class Main {

    public static void main(String[] args) {
        // те же яйца, только в профиль
        // у продукта есть статический метод для получения билдера
        // билдер объявлен как inner member class
        // а значит может set'ать поля продукта напрямую
        Product object = Product.builder()
                .field1("data1")
                .field2("data2")
                .field3("data3")
                .build();

        System.out.println(object);
        // SomeObject{field1='data1', field2='data2', field3='data3'}
    }
}
