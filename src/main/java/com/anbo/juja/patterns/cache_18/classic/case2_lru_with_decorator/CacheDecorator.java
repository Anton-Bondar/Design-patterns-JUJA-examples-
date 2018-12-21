package com.anbo.juja.patterns.cache_18.classic.case2_lru_with_decorator;

/**
 * Created by oleksandr.baglai on 11.01.2016.
 */
// очень легковестный кеш-декоратор
// реализует ту же абстракцию...
public class CacheDecorator implements Provider {

    // ...что сам хранит
    private Provider provider;
    private LRUCache cache;

    // при этом получает ее из конструктора
    public CacheDecorator(Provider provider, int maxSize) {
        this.provider = provider;
        // попутно создает кеш заданного размера
        this.cache = new LRUCache(maxSize);
    }

    // и в интерфейсном методе получения ресурса
    @Override
    public Resource get(int key) {
        // пробуем получить из кеша
        // если нет, то берем из поставщика
        Resource resource = cache.get(key);
        if (resource == null) {
            resource = provider.get(key);
            if (resource != null) {
                cache.put(key, resource);
            }
        }
        return resource;
    }

}
