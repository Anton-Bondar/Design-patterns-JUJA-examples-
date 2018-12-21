package com.anbo.juja.patterns.builder_20.classic.case0_classic;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by oleksandr.baglai on 07.02.2016.
 */
public class ConcreteBuilderTest {

    @Test
    public void test() {
        // given
        Builder builder = new ConcreteBuilder();

        // when
        builder.buildPart1();
        builder.buildPart2();
        builder.buildPart3();
        builder.buildPart4();

        // then
        Product product = builder.getResult();
        assertEquals("SomeObject{field1='data1', field2='data2', field3='data3'}",
                product.toString());
    }
}