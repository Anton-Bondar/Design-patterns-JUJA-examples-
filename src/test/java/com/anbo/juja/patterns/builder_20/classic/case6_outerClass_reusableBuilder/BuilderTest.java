package com.anbo.juja.patterns.builder_20.classic.case6_outerClass_reusableBuilder;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Created by oleksandr.baglai on 07.02.2016.
 */
public class BuilderTest {

    // Все поля сетим
    @Test
    public void testAllFields() {
        Product object1 =
                Builder.field1("data1")
                        .field2("data2")
                        .field3("data3")
                        .build();

        assertEquals("data1", object1.getField1());
        assertEquals("data2", object1.getField2());
        assertEquals("data3", object1.getField3());
    }

    // сетим только два поля
    @Test
    public void testOnlyTwoFields() {
        Product object1 =
                Builder.field1("data1")
                        .field2("data2")
//                        .field3("data3")
                        .build();

        assertEquals("data1", object1.getField1());
        assertEquals("data2", object1.getField2());
        assertEquals(null, object1.getField3());
    }

    // сетим только одно поле (тут валидации нет)
    @Test
    public void testOnlyOneField() {
        Product object1 =
                Builder.field1("data1")
                //        .field2("data2")
                //        .field3("data3")
                        .build();

        assertEquals("data1", object1.getField1());
        assertEquals(null, object1.getField2());
        assertEquals(null, object1.getField3());
    }

    // тестируем повторное использование билдера для создания
    // множества объектов с одинаковыми свойствами
    @Test
    public void testReuseBuilder() {
        Builder builder1 = Builder.field1("data1");
        Builder builder21 = builder1.field2("data21");
        Builder builder22 = builder1.field2("data22");
        Builder builder2131 = builder21.field3("data31");
        Builder builder2232 = builder22.field3("data32");

        Product object1 = builder2131.build();
        Product object2 = builder2232.build();

        assertEquals("SomeObject{field1='data1', field2='data21', field3='data31'}",
                object1.toString());

        assertEquals("SomeObject{field1='data1', field2='data22', field3='data32'}",
                object2.toString());
    }

    // тестируем, что изменение настроек билдера не влияет
    // на уже созданный объект, только на новый
    @Test
    public void testFixOldValues() {
        Builder builder =
                Builder.field1("data1")
                        .field2("data2")
                        .field3("data3");
        Product object1 = builder.build();
        Product object2 = builder.field2("changed2").build();

        assertEquals("SomeObject{field1='data1', field2='data2', field3='data3'}",
                object1.toString());

        assertEquals("SomeObject{field1='data1', field2='changed2', field3='data3'}",
                object2.toString());
    }
}
