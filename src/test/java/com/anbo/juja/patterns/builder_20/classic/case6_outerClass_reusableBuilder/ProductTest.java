package com.anbo.juja.patterns.builder_20.classic.case6_outerClass_reusableBuilder;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by oleksandr.baglai on 07.02.2016.
 */
public class ProductTest {

    // тут все просто - pojo бин тестим
    @Test
    public void test() throws Exception {
        // given when
        Product product = new Product("data1", "data2");
        product.setField3("data3");

        // then
        assertEquals("data1", product.getField1());
        assertEquals("data2", product.getField2());
        assertEquals("data3", product.getField3());

        assertEquals("SomeObject{field1='data1', field2='data2', field3='data3'}",
                product.toString());
    }
}