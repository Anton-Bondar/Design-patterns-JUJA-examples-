package com.anbo.juja.patterns.cache_18.classic.case2_lru_with_decorator;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.*;

/**
 * Created by oleksandr.baglai on 11.01.2016.
 */
public class LRUCacheTest {

    // данные в кеше есть
    @Test
    public void testExist() {
        // given
        LRUCache cache = new LRUCache(10);

        // when
        cache.put(1, new Resource(1));
        cache.put(2, new Resource(2));

        // then
        assertEquals(true, cache.contains(1));
        assertEquals(true, cache.contains(2));

        assertEquals("Resource:1", cache.get(1).toString());
        assertEquals("Resource:2", cache.get(2).toString());
    }

    // запрашиваем несуществующие данные
    @Test
    public void testNotExist() {
        // given
        LRUCache cache = new LRUCache(10);

        // when
        cache.put(1, new Resource(1));

        // then
        assertEquals(false, cache.contains(4));
        assertEquals(null, cache.get(4));
    }

    // кеш переполнен
    @Test
    public void testMoreThanMaxSize() {
        // given
        LRUCache cache = new LRUCache(2);

        // when
        cache.put(1, new Resource(1));
        cache.put(2, new Resource(2));
        cache.put(3, new Resource(3));

        // then
        assertEquals(false, cache.contains(1));
        assertEquals(true, cache.contains(2));
        assertEquals(true, cache.contains(3));

        assertEquals(null, cache.get(1));
        assertEquals("Resource:2", cache.get(2).toString());
        assertEquals("Resource:3", cache.get(3).toString());
    }

    // кеш может сохранять null значения
    @Test
    public void testNullValue() {
        // given
        LRUCache cache = new LRUCache(10);

        // when
        cache.put(1, null);

        // then
        assertEquals(true, cache.contains(1));
        assertEquals(null, cache.get(1));
    }
}
