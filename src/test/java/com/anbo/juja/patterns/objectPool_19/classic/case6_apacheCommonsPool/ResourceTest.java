package com.anbo.juja.patterns.objectPool_19.classic.case6_apacheCommonsPool;

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
        Resource resource = new Resource();

        // when
        resource.doit("data");

        // then
        assertEquals("Resource@1 processed: data\n", console.getOut());
        assertEquals("Resource@1", resource.toString());
    }
}
