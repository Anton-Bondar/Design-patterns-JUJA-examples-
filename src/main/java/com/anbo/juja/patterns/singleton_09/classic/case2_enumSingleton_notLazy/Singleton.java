package com.anbo.juja.patterns.singleton_09.classic.case2_enumSingleton_notLazy;

/**
 * Created by oleksandr.baglai on 15.10.2015.
 */
// остроумная реализация, безопасная для многопоточного использования, но так же не ленивая

// enum дает нам так же некоторые фичи:
// 1) возможность серелизации
// 2) возможность использовать EnumSet, EnumMap
// 3) поддержка switch
public enum Singleton {

    // экземпляр :)
    INSTANCE;

    // конструктор enum все равно никто не вызовет извне
    Singleton() {
        // какие-то сложные вычисления, которые мы хотим, чтобы выполнялись единожды
        System.out.println("Инстанциировали Singleton!");
    }
}
