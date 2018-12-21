package com.anbo.juja.patterns.cache_18.classic.case2_lru_with_decorator;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by oleksandr.baglai on 11.01.2016.
 */
public class ProviderImplTest {

    @Test
    public void testGetResource() {
        // given
        Provider provider = new ProviderImpl();

        // when
        Resource resource = provider.get(13);

        // then
        assertEquals("Resource:13", resource.toString());
    }
}
