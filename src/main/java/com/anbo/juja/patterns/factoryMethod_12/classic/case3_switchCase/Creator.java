package com.anbo.juja.patterns.factoryMethod_12.classic.case3_switchCase;

/**
 * Created by oleksandr.baglai on 11.11.2015.
 */
// абстракция фабрики
// опять же могут быть несколько реализаций, но у нас тут одна
public interface Creator {

    // обрати внимание, появился параметр productName -
    // по нему фектори определит какой продукт клиенту надо
    //
    // и наконец-то мы переименовали, теперь оно
    // звучит, а не то что раньше templateMethod!
    Product createProduct(String productName);
}
