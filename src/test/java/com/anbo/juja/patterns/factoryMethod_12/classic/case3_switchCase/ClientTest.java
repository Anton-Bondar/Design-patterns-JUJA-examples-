package com.anbo.juja.patterns.factoryMethod_12.classic.case3_switchCase;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by oleksandr.baglai on 11.11.2015.
 */
public class ClientTest {

    private String productName;

    @Test
    public void shouldProcess() {
        // given
        Client client = new Client();

        Creator creator = new Creator() {
            @Override
            public Product createProduct(String productName) {
                ClientTest.this.productName = productName;

                return new Product() {
                    @Override
                    public String process(String data) {
                        return data + "_changed";
                    }
                };
            }
        };

        // when
        String result = client.process("data", creator, "product");

        // then
        assertEquals("data_changed", result);
        assertEquals("product", productName);
    }
}
