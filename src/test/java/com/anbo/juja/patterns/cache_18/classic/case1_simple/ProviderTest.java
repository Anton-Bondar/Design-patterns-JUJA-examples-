package com.anbo.juja.patterns.cache_18.classic.case1_simple;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by oleksandr.baglai on 11.01.2016.
 */
public class ProviderTest {

    @Test
    public void testGetResource() {
        // given
        Provider provider = new Provider();

        // when
        Resource resource = provider.get(13);

        // then
        assertEquals("Resource:13", resource.toString());
    }
}
