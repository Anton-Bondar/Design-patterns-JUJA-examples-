package com.anbo.juja.patterns.builder_20.classic.case6_outerClass_reusableBuilder;

import org.junit.Test;
import ua.com.juja.patterns.objectPool.ConsoleMock;

import static org.junit.Assert.assertEquals;

/**
 * Created by oleksandr.baglai on 11.01.2016.
 */
public class MainTest {

    ConsoleMock console = new ConsoleMock();

    @Test
    public void test() throws Exception {
        // when
        Main.main(new String[0]);

        // then
        assertEquals("SomeObject{field1='data1', field2='data2', field3='data3'}\n" +
                        "SomeObject{field1='data1', field2='data2', field3='data3'}\n" +
                        "SomeObject{field1='data1', field2='changed2', field3='data3'}\n" +
                        "SomeObject{field1='data1', field2='data2', field3='changed3'}\n",
                console.getOut());
    }
}
