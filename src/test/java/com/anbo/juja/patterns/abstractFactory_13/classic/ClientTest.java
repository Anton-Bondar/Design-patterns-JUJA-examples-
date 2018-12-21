package com.anbo.juja.patterns.abstractFactory_13.classic;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

/**
 * Created by oleksandr.baglai on 11.11.2015.
 */
public class ClientTest {

    // тут мы сохраняем промужуточное состояние
    private String one;
    private String another;
    private String something;

    @Test
    public void shouldProcess() {
        // given
        Client client = new Client();

        // изначально пусть будет так
        one = "one";
        another = "another";
        something = "something";

        // все наши продукты анонимно реализованы так чтобы работать с полями

        final Product1 product1 = new Product1() {
            @Override
            public String process(String data) {
                return data + "_changed";
            }
        };

        final Product2 product2 = new Product2() {
            @Override
            public void setOne(String data) {
                one = data;
            }

            @Override
            public void setAnother(String data) {
                another = data;
            }
        };

        final Product3 product3 = new Product3() {
            @Override
            public String getOne() {
                return one;
            }

            @Override
            public String getAnother() {
                return another;
            }

            @Override
            public String getSomething() {
                return something;
            }
        };

        // это абстрактная фабрика, связывающая все продукты вместе
        AbstractFactory creator = new AbstractFactory() {
            @Override
            public Product1 createProduct1() {
                return product1;
            }

            @Override
            public Product2 createProduct2() {
                return product2;
            }

            @Override
            public Product3 createProduct3() {
                return product3;
            }
        };

        // when
        Product2 result = client.process(creator);

        // then
        assertSame(product2, result);
        assertEquals("one_changed", one);
        assertEquals("another_changed", another);
        assertEquals("something", something);
    }
}
