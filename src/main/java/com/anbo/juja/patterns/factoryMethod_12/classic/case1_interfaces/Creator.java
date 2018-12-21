package com.anbo.juja.patterns.factoryMethod_12.classic.case1_interfaces;

/**
 * Created by oleksandr.baglai on 11.11.2015.
 */
// абстракция фабрики
//
// тут может быть и абстрактный класс,
// если нам надо со всеми продуктами что-то однотипное делать (case2)
public interface Creator {

    // каждая фабрика должна реализовать это
    // вообще хороший конвеншен, когда метод называется
    // Product createProduct();
    Product factoryMethod();

}
