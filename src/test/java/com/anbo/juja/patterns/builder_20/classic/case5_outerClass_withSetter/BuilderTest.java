package com.anbo.juja.patterns.builder_20.classic.case5_outerClass_withSetter;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Created by oleksandr.baglai on 07.02.2016.
 */
public class BuilderTest {

    // классический запуск - все поля инитим
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

    // часть полей можно не стеапить
    @Test
    public void testOnlyMandatoryFields() {
        Product object1 =
                Builder.field1("data1")
                        .field2("data2")
//                        .field3("data3")
                        .build();

        assertEquals("data1", object1.getField1());
        assertEquals("data2", object1.getField2());
        assertEquals(null, object1.getField3());
    }

    // тестируем ошибку валидации, если билдим без установленного поля
    @Test
    public void testErrorWhenNotSetMandatoryField() {
        try {
            Product object1 =
                    Builder.field1("data1")
//                        .field2("data2")
//                        .field3("data3")
                            .build();
            fail("Expected exception");
        } catch (IllegalArgumentException e) {
            assertEquals("Вы забыли установить field2", e.getMessage());
        }
    }
}
