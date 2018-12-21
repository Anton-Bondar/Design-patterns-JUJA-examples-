package com.anbo.juja.patterns.cache_18.classic.case2_lru_with_decorator;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by oleksandr.baglai on 11.01.2016.
 */
// реализация LRU (least recently used) кеша
// задаем размер на старте, рабоатем-рабоатем (прогреваем кеш)
// а при переполнении удаляется самый-давно-не-используемый
// спасибо http://www.javaspecialist.ru/2012/02/java-lru-cache.html за размышления на тему
public class LRUCache {
    private Map<Integer, Resource> data;

    public LRUCache(final int maxSize) {
        // на основе LinkedHashMap, который HashMap но с сохранением порядка
        // спасибо http://stackoverflow.com/a/224886 за этот хороший хак
        this.data = new LinkedHashMap(maxSize + 1, .75F, true) {
            // этот метод будет вызван сразу после добавления нового элемента
            public boolean removeEldestEntry(Map.Entry eldest) {
                boolean willRemove = size() > maxSize;
                if (willRemove) {
                    System.out.println("Removing " + eldest.getValue());
                }
                return willRemove;
            }
        };

        // подобная реализация с использованием LRUMap из Apache Commons Collections
        // спасибо http://blog.riamaria.com/32/caching-in-java-with-lrumap/
        // this.data = new LRUMap(maxSize) {
        //     @Override
        //     protected boolean removeLRU(LinkEntry eldest) {
        //         System.out.println("Removing " + eldest.getValue());
        //         return super.removeLRU(eldest);
        //     }
        // };
    }

    // получаем элемент из кеша
    public Resource get(int key) {
        return data.get(key);
    }

    // вставляем элемент в кеш
    public void put(int key, Resource resource) {
        data.put(key, resource);
    }

    // проверяем, есть ли элемент
    public boolean contains(int key) {
        return data.containsKey(key);
    }
}
