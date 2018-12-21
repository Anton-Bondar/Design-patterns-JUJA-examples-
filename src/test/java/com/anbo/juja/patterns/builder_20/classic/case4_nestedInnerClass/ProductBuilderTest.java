package com.anbo.juja.patterns.builder_20.classic.case4_nestedInnerClass;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by oleksandr.baglai on 07.02.2016.
 */
public class ProductBuilderTest {

    @Test
    public void test() throws Exception {
        // given
        // тут у нас билдер как nested inner class
        Product.Builder builder = new Product.Builder();

        // when
        builder.field1("data1");
        builder.field2("data2").field3("data3");

        Product product = builder.build();

        // then
        assertEquals("data1", product.getField1());
        assertEquals("data2", product.getField2());
        assertEquals("data3", product.getField3());

        assertEquals("SomeObject{field1='data1', field2='data2', field3='data3'}",
                product.toString());
    }
}