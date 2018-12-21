package com.anbo.juja.patterns.factoryMethod_12.classic.case2_abstractClass;

/**
 * Created by oleksandr.baglai on 11.11.2015.
 */
// а это абстракция продукта
// тут может быть и абстрактный класс
public interface Product {

    // метод для работы клиента
    String process(String data);

    // метод настройки продукта
    void setup(String config);
}
