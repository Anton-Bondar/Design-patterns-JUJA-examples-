package com.anbo.juja.patterns.nullObject_15.classic.case1_interfaces;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by oleksandr.baglai on 10.12.2015.
 */
public class Client2Test {

    public String input;

    // все так же тест без мокито
    @Test
    public void testWithoutMockito() {
        // given
        Abstraction abstraction = new Abstraction() {

            @Override
            public void request(String input) {
                Client2Test.this.input = input;
            }
        };

        Client2 client = new Client2();

        // when
        client.doSomething(abstraction);

        // then
        assertEquals("data", input);
    }

    // а тут с мокито
    @Test
    public void testWithMockito() {
        // given
        Abstraction abstraction = mock(Abstraction.class);
        Client2 client = new Client2();

        // when
        client.doSomething(abstraction);

        // then
        verify(abstraction).request("data");
    }
}
