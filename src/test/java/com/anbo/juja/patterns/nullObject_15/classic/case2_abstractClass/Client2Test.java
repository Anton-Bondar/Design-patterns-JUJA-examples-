package com.anbo.juja.patterns.nullObject_15.classic.case2_abstractClass;

import org.junit.Before;
import org.junit.Test;
import ua.com.juja.patterns.nullObject.ConsoleMock;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.when;

/**
 * Created by oleksandr.baglai on 10.12.2015.
 */
public class Client2Test {

    // тут все как в Client1Test
    // только не через конструктор объект инджектится
    // а передается в метод

    private ConsoleMock console = new ConsoleMock();

    public String input1;
    public String input2;
    public boolean input3;
    private String input41;
    private String input42;
    private String input51;
    private String input52;

    private AbstractObject object;
    private Client2 client;

    @Before
    public void setup() {
        // given
        object = new AbstractObject() {
            @Override
            public void request1(String input) {
                Client2Test.this.input1 = input;
            }

            @Override
            public String request2() {
                return Client2Test.this.input2;
            }

            @Override
            public void request3() {
                Client2Test.this.input3 = true;
            }

            @Override
            public void request4(String input1, String input2) {
                Client2Test.this.input41 = input1;
                Client2Test.this.input42 = input2;
            }

            @Override
            public String request5(String input) {
                Client2Test.this.input51 = input;
                return Client2Test.this.input52;
            }
        };

        client = new Client2();
    }

    @Test
    public void testWithoutMockito() {
        // given
        input2 = "result2";
        input52 = "result5";

        // when
        client.doSomething(object);

        // then
        assertEquals("data", input1);
        assertEquals(true, input3);
        assertEquals("data", input41);
        assertEquals("result2", input42);
        assertEquals("data", input51);

        assertEquals("result2result5", console.getOut());
    }

    // ну и лаконичный тест с мокито
    @Test
    public void testWithMockito() {
        // given
        AbstractObject object = mock(AbstractObject.class);
        when(object.request2()).thenReturn("result2");
        when(object.request5(anyString())).thenReturn("result5");

        // when
        client.doSomething(object);

        // then
        verify(object).request1("data");
        verify(object).request2();
        verify(object).request3();
        verify(object).request4("data", "result2");
        verify(object).request5("data");

        assertEquals("result2result5", console.getOut());
    }
}
