package com.anbo.juja.patterns.builder_20.classic.case2_doubleBraceInitialization_withBuilder;

/**
 * Created by oleksandr.baglai on 07.02.2016.
 */
// класс-запускатор
// спасибо за пример https://habrahabr.ru/post/261163/
//
// улучшения:
// + проблема с наследованием-equals решена
// + можно сделать проверку полей
// + поддерживает создание immutable объектов
// + утечки памяти нет, т.к. ссылка на билдер теряется после создания объкта
public class Main {

    public static void main(String[] args) {
        // тот же подход что и в прошлом примере, только
        // анонимно мы занаследовали билдер, а не сам продукт
        Product object = new Product.Builder() {{
            field1 = "data1";
            field2 = "data2";
            field3 = "data3";
        }}.build();

        System.out.println(object);
        // SomeObject{field1='data1', field2='data2', field3='data3'}
    }
}
