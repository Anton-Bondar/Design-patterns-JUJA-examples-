package com.anbo.juja.patterns.nullObject_15.classic.case1_interfaces;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by oleksandr.baglai on 10.12.2015.
 */
public class Client1Test {

    // тут будем хранить то что прийдет в Abstraction
    public String input;

    // тест без мокито, на анонимной реализации интерфейса
    @Test
    public void testWithoutMockito() {
        // given
        Abstraction abstraction = new Abstraction() {

            @Override
            public void request(String input) {
                Client1Test.this.input = input;
            }
        };

        Client1 client = new Client1(abstraction);

        // when
        client.doSomething("data");

        // then
        assertEquals("data_changed", input);
    }

    // тест с мокито - он проще, согласись :)
    @Test
    public void testWithMockito() {
        // given
        Abstraction abstraction = mock(Abstraction.class);
        Client1 client = new Client1(abstraction);

        // when
        client.doSomething("data");

        // then
        verify(abstraction).request("data_changed");
    }
}
