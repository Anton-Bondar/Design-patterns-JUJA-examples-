package com.anbo.juja.patterns.simpleFactory_14.classic.case2_inheritance;

/**
 * Created by oleksandr.baglai on 30.11.2015.
 */
// общая часть у всех продуктов, в данном примере - интерфейс
public abstract class AbstractProduct {

    // тут могут быть какие-то поля общие для всех продуктов

    // а тут общие методы
    public String somethingCommon() {
        return "common";
    }

    // а это то, что продукту прийдется доопределить
    abstract String getSomething();
}
