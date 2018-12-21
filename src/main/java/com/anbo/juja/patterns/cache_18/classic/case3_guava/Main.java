package com.anbo.juja.patterns.cache_18.classic.case3_guava;

import com.google.common.cache.*;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * Created by oleksandr.baglai on 11.01.2016.
 */
// класс запускатор
// за деталями использования бибоиотеки идем сюда
// https://code.google.com/p/guava-libraries/wiki/CachesExplained
public class Main {

    public static void main(String[] args) throws ExecutionException {
        // строим наш кеш с помощью Google Guava
        LoadingCache<Integer, Resource> resources =
                CacheBuilder.newBuilder()
                        // вместимость кеша
                        .maximumSize(4)
                        // через 10 секунд после создания ресурс будет помечен на удаление
                        .expireAfterWrite(10, TimeUnit.SECONDS)
                        // когда он будет удален, то вызовется этот калбэк
                        .removalListener(new RemovalListener<Integer, Resource>() {
                            @Override
                            public void onRemoval(RemovalNotification<Integer, Resource> removalNotification) {
                                System.out.println("Removing " + removalNotification.getValue());
                            }
                        })
                        // есть и другие методы у билдера
                        // .maximumWeight(
                        // .concurrencyLevel(
                        // .expireAfterAccess(
                        // .initialCapacity(
                        // .recordStats(
                        // .refreshAfterWrite(
                        // .softValues(
                        // .ticker(
                        // а тут описываем источник ресурсов
                        .build(new CacheLoader<Integer, Resource>() {
                            public Resource load(Integer key) throws Exception {
                                return loadResource(key);
                            }
                        });

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

    private static Resource loadResource(int id) {
        sleep(1000);
        Resource resource = new Resource(id);
        System.out.println("Created " + resource);
        return resource;
    }

    // метод для задержки в миллисекундах
    private static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
