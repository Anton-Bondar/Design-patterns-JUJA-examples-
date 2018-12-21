package com.anbo.juja.patterns.cache_18.classic.case1_simple;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by oleksandr.baglai on 11.01.2016.
 */
// наш источник ресурсов с встроенным анлим-кешем
// пример нарушения SRP, но нам для примера
public class Cache {

    // тут (как говорят in memory) будем хранить то что напродуцировали
    private Map<Integer, Resource> data = new HashMap<>();
    private Provider provider;

    public Cache(Provider provider) {
        this.provider = provider;
    }

    // главный метод получения ресурсов
    public Resource get(int id) {
        // пробуем вначале взять из кеша
        Resource resource = data.get(id);
        if (resource != null) {
            // если есть ресурс - супер! возвращаем
            return resource;
        }

        // в кеше ресурса нет, берем его болле долгим способом
        resource = provider.get(id);
        if (resource != null) {
            // и если успех, то сохраняем в кеше
            data.put(id, resource);
        }
        // а потом возвращаем клиенту
        return resource;
    }
}
