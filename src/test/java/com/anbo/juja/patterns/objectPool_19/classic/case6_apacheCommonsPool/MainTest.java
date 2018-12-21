package com.anbo.juja.patterns.objectPool_19.classic.case6_apacheCommonsPool;

import org.junit.Test;
import ua.com.juja.patterns.objectPool.classic.AbstractTest;

import static org.junit.Assert.assertEquals;

/**
 * Created by oleksandr.baglai on 11.01.2016.
 */
public class MainTest extends AbstractTest {

    @Test
    public void test() throws Exception {
        // when
        Main.main(new String[0]);

        // then
        assertEquals("get Resource@1 from pool\n" +
                "get Resource@2 from pool\n" +
                "Resource@1 processed: data1\n" +
                "put Resource@1 to pool\n" +
                "get Resource@1 from pool\n" +
                "Resource@1 processed: data3\n" +
                "put Resource@1 to pool\n" +
                "Resource@2 processed: data2\n" +
                "put Resource@2 to pool\n", console.getOut());
    }
}
