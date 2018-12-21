package com.anbo.juja.patterns.factoryMethod_12.classic.case2_abstractClass;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by oleksandr.baglai on 11.11.2015.
 */
public class ClientTest {

    private String config;

    @Test
    public void shouldProcess() {
        // given
        Client client = new Client();

        Creator creator = new Creator() {
            @Override
            public Product factoryMethod() {
                return new Product() {

                    @Override
                    public String process(String data) {
                        return data + "_changed";
                    }

                    @Override
                    public void setup(String config) {
                        ClientTest.this.config = config;
                    }
                };
            }
        };

        // when
        String result = client.process("data", "config", creator);

        // then
        assertEquals("data_changed", result);
        assertEquals("config", config);
    }
}
