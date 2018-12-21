package com.anbo.juja.patterns.singleton_09.classic.case1_finalField_notLazy;

/**
 * Created by oleksandr.baglai on 15.10.2015.
 */
public class Main {

    public static void main(String[] args) {
        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();
        Singleton singleton3 = Singleton.getInstance();

        if (singleton1 == singleton2 && singleton2 == singleton3) {
            System.out.println("Успех! Только один экземпляр был создан.");
        } else {
            System.out.println("Йойкс! Что-то пошло не так, у нас разные экземпляры.");
        }
    }

}
