package com.anbo.juja.patterns.objectPool_19.sample.simpleConnectionPool;

import org.junit.Test;
import ua.com.juja.patterns.objectPool.classic.AbstractTest;

import static org.junit.Assert.assertEquals;

/**
 * Created by oleksandr.baglai on 11.01.2016.
 */
public class SampleHsqldbTest extends AbstractTest {

    @Test
    public void test() throws Exception {
        // when
        SampleHsqldb.main(new String[0]);

        // then
        assertEquals("0 Qwe\n" +
                "1 Asd\n" +
                "2 Zxc\n", console.getOut());
    }
}
