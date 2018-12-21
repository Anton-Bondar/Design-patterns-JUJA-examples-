package com.anbo.juja.patterns.abstractFactory_13.classic;

/**
 * Created by oleksandr.baglai on 22.11.2015.
 */
// абстракция фабрики
// каждая фабрика должна реализовать это
//
// тут может быть и абстрактный класс,
// если нам надо со всеми продуктами что-то однотипное делать (case2)
public interface AbstractFactory {

    Product1 createProduct1();

    Product2 createProduct2();

    Product3 createProduct3();

}
