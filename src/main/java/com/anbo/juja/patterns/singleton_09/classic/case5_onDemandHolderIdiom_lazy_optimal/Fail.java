package com.anbo.juja.patterns.singleton_09.classic.case5_onDemandHolderIdiom_lazy_optimal;

/**
 * Created by oleksandr.baglai on 16.10.2015.
 */
// Спасибо за пример https://en.wikipedia.org/wiki/Initialization-on-demand_holder_idiom
// в нем описывается случай, когда в конструкторе синглтона возникла ошибка
// и это привело к тому, что больше мы не можем им пользоваться никогда
public class Fail {

    // наш синглтон
    public static class Singleton {
        // флаг c помощью которого мы семулируем первый сбой, а потом все будет ок
        private static boolean failure = true;

        // конструктор в котором может быть ошибка
        private Singleton() {
            System.out.println("Конструктор: " + getClass().getSimpleName());

            // только первый раз сбой
            if (failure) {
                // потом все будет ок
                failure = false;
                System.out.println("Йойкс! Марсиане украли кабель!!!");
                throw new RuntimeException("Ошибка!!!");
            }
        }

        // остальная часть синглтона
        private static class LazyHolder {
            private static final Singleton instance = new Singleton();

            // исправить можно было бы так
            // private static Singleton instance;
            // static {
            //     try {
            //         instance = new Singleton();
            //     } catch (Exception e) {
            //         System.out.println("Невозможно инстанциировать " +
            //                 "Singleton по причине: " + e);
            //         System.out.println("Пробуем еще раз");
            //         instance = new Singleton();
            //     }
            // }
        }

        public static Singleton getInstance() {
            return LazyHolder.instance;
        }
    }

    public static void main(String[] args) {
        System.out.println("Первая попытка");
        try {
            Singleton.getInstance();
        } catch (Throwable t) {
            System.out.println("Поймали ошибку:" + t);
        }

        System.out.println("Вторая попытка");
        try {
            Singleton.getInstance();
        } catch (Throwable t) {
            System.out.println("Поймали ошибку:" + t);
        }

        // Вывод:
        // Первая попытка
        // Конструктор: Singleton
        // Йойкс! Марсиане украли кабель!!!
        // Поймали ошибку:java.lang.ExceptionInInitializerError
        // Вторая попытка
        // Поймали ошибку:java.lang.NoClassDefFoundError: Could not initialize class ua.com.juja.patterns.singleton.classic.case5_onDemandHolderIdiom_lazy_safeMultithreading_optimal_forStaticFieldOnly.Fail$Singleton$LazyHolder
    }
}
