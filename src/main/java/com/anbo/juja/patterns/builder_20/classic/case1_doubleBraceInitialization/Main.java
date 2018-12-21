package com.anbo.juja.patterns.builder_20.classic.case1_doubleBraceInitialization;

/**
 * Created by oleksandr.baglai on 07.02.2016.
 */
// класс-запускатор
// спасибо за пример https://habrahabr.ru/post/261163/
//
// недостатки:
// - мы создаем анонимный унаследованный класс
//   и вмешиваемся в цепочку наследования, а от этого стандартный
//   equals может не корректно работать
// - возможная утечка памяти, т.к. анонимный класс будет держать ссылку на контекст создания
// - инициализация полей без проверок
// - не поддерживает создание immutable объектов
public class Main {

    public static void main(String[] args) {
        // так как поля protected то в блоке динамической инициализации класса
        // мы можем их переопределить
        // в результате у нас будет анонимно занаследованный класс
        // в котором поля инитятся default значениями
        Product object = new Product() {{
            field1 = "data1";
            field2 = "data2";
            field3 = "data3";
        }};

        System.out.println(object);
        // SomeObject{field1='data1', field2='data2', field3='data3'}
    }
}
