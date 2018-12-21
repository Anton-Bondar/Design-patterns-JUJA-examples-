package com.anbo.juja.patterns.cache_18.classic.case2_lru_with_decorator;

/**
 * Created by oleksandr.baglai on 11.01.2016.
 */
// класс запускатор
public class Main {

    public static void main(String[] args) {
        // источник ресурсов
        ProviderImpl provider = new ProviderImpl();
        // кеш-декоратор с вместимостью до 4х ресурсов
        Provider resources = new CacheDecorator(provider, 4);

        // вывод:
        System.out.println("Get " + resources.get(10));
        // Created Resource:10
        // Get Resource:10
        System.out.println("Get " + resources.get(10));
        // Get Resource:10
        System.out.println("Get " + resources.get(11));
        // Created Resource:11
        // Get Resource:11
        System.out.println("Get " + resources.get(12));
        // Created Resource:12
        // Get Resource:12
        System.out.println("Get " + resources.get(10));
        // Get Resource:10
        System.out.println("Get " + resources.get(13));
        // Created Resource:13
        // Get Resource:13

        // обрати внимание, тут переполнение кеша и потому
        // самый древний элемент будет удален
        // не 10, так как к нему получали доступ недавно, а 11
        System.out.println("Get " + resources.get(14));
        // Created Resource:14
        // Removing Resource:11
        // Get Resource:14
        System.out.println("Get " + resources.get(10));
        // Get Resource:10
    }
}
