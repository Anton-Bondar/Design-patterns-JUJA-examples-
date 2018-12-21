package com.anbo.juja.patterns.builder_20.classic.case0_classic;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by oleksandr.baglai on 07.02.2016.
 */
public class ProductTest {

    @Test
    public void test() throws Exception {
        // given
        Product product = new Product();

        // when
        product.setField1("data1");
        product.setField2("data2");
        product.setField3("data3");

        // then
        assertEquals("data1", product.getField1());
        assertEquals("data2", product.getField2());
        assertEquals("data3", product.getField3());

        assertEquals("SomeObject{field1='data1', field2='data2', field3='data3'}",
                product.toString());
    }
}