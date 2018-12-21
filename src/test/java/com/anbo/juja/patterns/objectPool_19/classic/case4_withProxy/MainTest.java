package com.anbo.juja.patterns.objectPool_19.classic.case4_withProxy;

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
        assertEquals("init pool...\n" +
                "put ResourceImpl@1 to pool\n" +
                "put ResourceImpl@2 to pool\n" +
                "put ResourceImpl@3 to pool\n" +
                "...init done!\n" +
                "get ResourceImpl@1 from pool\n" +
                "get ResourceImpl@2 from pool\n" +
                "get ResourceImpl@3 from pool\n" +
                "ResourceImpl@1 processed: data1\n" +
                "ResourceImpl@3 processed: data3\n" +
                "ResourceImpl@2 processed: data2\n" +
                "put ResourceImpl@1 to pool\n" +
                "put ResourceImpl@2 to pool\n" +
                "put ResourceImpl@3 to pool\n", console.getOut());
    }
}
