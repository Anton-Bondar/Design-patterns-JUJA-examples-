package com.anbo.juja.patterns.factoryMethod_12.classic.case2_abstractClass;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by oleksandr.baglai on 11.11.2015.
 */
public class CreatorTest {

    private String config;

    @Test
    public void shouldCreate() {
        // given
        Creator creator = new Creator() {
            @Override
            protected Product factoryMethod() {
                return new Product() {
                    @Override
                    public String process(String data) {
                        return data + "_changed";
                    }

                    @Override
                    public void setup(String config) {
                        CreatorTest.this.config = config;
                    }
                };
            }
        };

        // when
        Product product = creator.create("config");
        String result = product.process("data");

        // then
        assertEquals("data_changed", result);
        assertEquals("config", config);
    }
}
