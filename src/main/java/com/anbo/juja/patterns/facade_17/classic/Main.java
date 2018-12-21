package com.anbo.juja.patterns.facade_17.classic;

/**
 * Created by oleksandr.baglai on 28.12.2015.
 */
public class Main {
    public static void main(String[] args) {
        // без фасада клиенту прийдется это все запомнить!
        // сколько тут зависимостей, а?
        Class5 class5 = new Class5();
        Class2 class2 = new Class2(class5);
        Class4 class4 = new Class4();
        class2.setClass4(class4); // а если что-то упустим важное?
        Class3 class3 = Class3.create();
        Class1 class1 = new Class1(class2, class3);

        // только чтобы сделать вот это
        String result = class1.doSomething("data");

        System.out.println(result);
        // Вывод: datadata

        // а теперь введем фасад
        Facade facade = new Facade();

        // и пусть клиент зависит только от него
        String result2 = facade.doSomething("data");

        System.out.println(result2);
        // Вывод: datadata
    }
}
