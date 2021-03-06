package com.anbo.juja.patterns.cache_18.classic.case1_simple;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.*;

/**
 * Created by oleksandr.baglai on 11.01.2016.
 */
public class CacheTest {

    // тестируем что кеш сперва берет данные из поставщика ресурсов
    @Test
    public void testGetResourceFromProvider() {
        // given
        Resource resource = new Resource(13);
        Provider provider = mock(Provider.class);
        when(provider.get(13)).thenReturn(resource);

        Cache cache = new Cache(provider);

        // when
        Resource actual = cache.get(13);

        // then
        assertSame(resource, actual);
        verify(provider, only()).get(13);
    }

    // а во второй раз на том же ключе кеш берет сохраненные у себя данные
    @Test
    public void testGetResourceFromCache() {
        // given
        Resource resource = new Resource(13);
        Provider provider = mock(Provider.class);
        when(provider.get(13)).thenReturn(resource);

        Cache cache = new Cache(provider);
        cache.get(13);

        // when
        Resource actual = cache.get(13);

        // then
        assertSame(resource, actual);
        verify(provider, only()).get(13);
    }
}
