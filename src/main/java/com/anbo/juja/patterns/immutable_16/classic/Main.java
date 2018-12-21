package com.anbo.juja.patterns.immutable_16.classic;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by oleksandr.baglai on 21.12.2015.
 */
// наша песочница
public class Main {

    // поэкспериментируем?
    public static void main(String[] args) {
        // сколько способов нарушить инкапсуляцию есть?
        caseMutableConstructor();
        caseMutableSubclass();
        caseMutableAnonymousSubclass();
        caseMutableSetter();
        caseMutableGetter();
        caseMutableReflection();

        printBreak();

        // попробуем то же с Immutable?
        caseImmutableConstructor();
        caseImmutableSubclass();
        caseImmutableAnonymousSubclass();
        caseImmutableSetter();
        caseImmutableGetter();
        caseImmutableReflection();

        // вывод:
        // [fail1]
        // [fail2, fail2]
        // [fail3]
        // [fail4, fail4]
        // [fail5]
        // [fail6]
        // -----------------
        // []
        // []
        // []
        // [fail6]
    }

    private static void printBreak() {
        System.out.println("-----------------");
    }

    private static void caseMutableConstructor() {
        List<String> list = new LinkedList<>();

        // первая - создали объект, передали список через конструктор
        Mutable mutable = new Mutable(list);

        // но оставили себе ссылочку, на всякий
        list.add("fail1");

        System.out.println(mutable);
    }

    // вторая - наследоваться от не final класса
    static class NewMutable extends Mutable {

        public NewMutable(List<String> data) {
            super(data);

            // и в наследнике менять protected поле
            data.add("fail2");
        }

        public void doSmth() {
            data.add("fail2");
        }
    }

    private static void caseMutableSubclass() {
        List<String> list = new LinkedList<>();

        // дальше пользоваться новым классом, под видом родителя
        NewMutable mutable = new NewMutable(list);

        mutable.doSmth();

        System.out.println(mutable);
    }
    
    private static void caseMutableAnonymousSubclass() {
        List<String> list = new LinkedList<>();

        // третья - анонимная реализация с блоком инициализации
        // тоже самое что и с наследованием, только красивее
        Mutable mutable = new Mutable(list) {
            {
                data.add("fail3");
            }
        };

        System.out.println(mutable);
    }

    private static void caseMutableSetter() {
        List<String> list = new LinkedList<>();

        Mutable mutable = new Mutable(list);

        // четвертая - воспользоваться сеттером
        List<String> newList = new LinkedList<>();
        newList.add("fail4");

        mutable.setData(newList);

        // а потом еще и добавлять что угодно
        newList.add("fail4");

        System.out.println(mutable);
    }

    private static void caseMutableGetter() {
        List<String> list = new LinkedList<>();

        Mutable mutable = new Mutable(list);

        // четвертая - воспользоваться геттером
        mutable.getData().add("fail5");

        System.out.println(mutable);
    }

    // ну и наконец, ничто не устоит перед рефлексией
    private static void caseMutableReflection() {
        List<String> list = new LinkedList<>();

        Mutable mutable = new Mutable(list);

        try {
            Field data = mutable.getClass().getDeclaredField("data");
            data.setAccessible(true);
            data.set(mutable, Arrays.asList("fail6"));
            data.setAccessible(false);
        } catch (Exception e) {
            // do nothing
        }

        System.out.println(mutable);
    }

    private static void caseImmutableConstructor() {
        List<String> list = new LinkedList<>();

        // первая - создали объект, передали список через конструктор
        Immutable immutable = new Immutable(list);

        // хоть мы и оставили себе ссылочку, на всякий
        // это бесполезно!
        list.add("fail1");

        System.out.println(immutable);
    }

    // наследоваться от Immutable не даст компилятор
    // static class NewImmutable extends Immutable {
    //     public NewImmutable(List<String> data) {
    //         super(data);
    // 
    //         // и в наследнике менять protected поле
    //         data.add("fail2");
    //     }
    // }

    private static void caseImmutableSubclass() {
        List<String> list = new LinkedList<>();

        // ну и дальше пользоваться новым классом, под видом родителя
        // не получится
        // Immutable immutable = new NewImmutable(list);
        // 
        // System.out.println(immutable);
    }

    private static void caseImmutableAnonymousSubclass() {
        List<String> list = new LinkedList<>();

        // третья - анонимная реализация с блоком инициализации
        // тоже самое что и с наследованием, только красивее
        // так же не получится - компилятор не даст
        // Immutable immutable = new Immutable(list) {
        //     {
        //         // да и поле приватное!
        //         data.add("fail3");
        //     }
        // };
        // 
        // System.out.println(immutable);
    }

    private static void caseImmutableSetter() {
        List<String> list = new LinkedList<>();

        Immutable immutable = new Immutable(list);

        // четвертая - воспользоваться сеттером
        List<String> newList = new LinkedList<>();
        newList.add("fail4");

        // а его нет :)
        // immutable.setData(newList);

        // а потом еще и добавлять что угодно
        // бессмысленно!
        newList.add("fail4");

        System.out.println(immutable);
    }

    private static void caseImmutableGetter() {
        List<String> list = new LinkedList<>();

        Immutable immutable = new Immutable(list);

        // четвертая - воспользоваться геттером
        // не получится - он возвращает копию
        immutable.getData().add("fail5");

        System.out.println(immutable);
    }

    // ну и наконец, ничто не устоит перед рефлексией
    // даже Immutable
    private static void caseImmutableReflection() {
        List<String> list = new LinkedList<>();

        Immutable immutable = new Immutable(list);

        try {
            Field data = immutable.getClass().getDeclaredField("data");
            data.setAccessible(true);
            data.set(immutable, Arrays.asList("fail6"));
            data.setAccessible(false);
        } catch (Exception e) {
            // do nothing
        }

        System.out.println(immutable);
    }
}
