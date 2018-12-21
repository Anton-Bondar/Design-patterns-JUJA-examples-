package com.anbo.juja.patterns.adapter_01.adapter1;

import org.junit.Test;
import static org.mockito.Mockito.*;

import static org.junit.Assert.assertEquals;

/**
 * Created by indigo on 19.08.2015.
 */
public class AdapterTest {
    @Test
    public void test() {
        // given
        Adaptee adaptee = mock(Adaptee.class);
        when(adaptee.specificRequest(anyObject())).thenReturn("data from adaptee");

        Target target = new Adapter(adaptee);

        // when
        Object actual = target.request("data");

        // then
        assertEquals("data from adaptee", actual);
        verify(adaptee).specificRequest("data");
    }
}
