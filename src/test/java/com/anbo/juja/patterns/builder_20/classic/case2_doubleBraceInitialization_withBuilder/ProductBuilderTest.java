package com.anbo.juja.patterns.builder_20.classic.case2_doubleBraceInitialization_withBuilder;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by oleksandr.baglai on 07.02.2016.
 */
public class ProductBuilderTest {

    @Test
    public void test() throws Exception {
        // given
        // тут у нас анонимный наследник nesten inner билдера
        // с переопределением полей
        Product.Builder builder = new Product.Builder(){
            {
                field1 = "data1";
                field2 = "data2";
                field3 = "data3";
            }
        };

        // when
        Product product = builder.build();

        // then
        assertEquals("data1", product.getField1());
        assertEquals("data2", product.getField2());
        assertEquals("data3", product.getField3());

        assertEquals("SomeObject{field1='data1', field2='data2', field3='data3'}",
                product.toString());
    }
}