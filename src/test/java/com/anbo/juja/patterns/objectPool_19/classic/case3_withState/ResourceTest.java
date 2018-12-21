package com.anbo.juja.patterns.objectPool_19.classic.case3_withState;

import org.junit.Test;
import ua.com.juja.patterns.objectPool.classic.AbstractTest;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by oleksandr.baglai on 28.01.2016.
 */
public class ResourceTest extends AbstractTest {

    @Test
    public void testWithoutState() {
        // given
        Resource resource = new Resource();

        // when
        resource.doit("data");

        // then
        assertEquals("Resource[null]@1 processed: data\n", console.getOut());
        assertEquals("Resource[null]@1", resource.toString());
    }

    @Test
    public void testWithState() {
        // given
        Resource resource = new Resource();

        // when
        resource.setState("state");
        resource.doit("data");


        // then
        assertEquals("Resource[null]@1 state = state\n" +
                "Resource[state]@1 processed: data\n", console.getOut());
        assertEquals("Resource[state]@1", resource.toString());
    }
}
