package com.anbo.juja.patterns.objectPool_19.classic.case4_withProxy;

import org.junit.Test;
import ua.com.juja.patterns.objectPool.classic.AbstractTest;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by oleksandr.baglai on 28.01.2016.
 */
public class ResourceTest extends AbstractTest {

    @Test
    public void test() {
        // given
        Resource resource = new ResourceImpl();

        // when
        resource.doit("data");

        // then
        assertEquals("ResourceImpl@1 processed: data\n", console.getOut());
        assertEquals("ResourceImpl@1", resource.toString());
    }

    @Test
    public void testClose() {
        // given
        Resource resource = new ResourceImpl();

        // when
        resource.close();

        // then
        assertEquals("", console.getOut());
    }
}
