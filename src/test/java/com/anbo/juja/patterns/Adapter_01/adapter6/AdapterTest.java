package com.anbo.juja.patterns.adapter_01.adapter6;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by indigo on 19.08.2015.
 */
public class AdapterTest {
    @Test
    public void test() {
        // given
        Adaptee adaptee = mock(Adaptee.class);
        when(adaptee.specificRequest(anyObject())).thenReturn("data from adaptee");

        Target target = Adapter.getProxy(adaptee);

        // when
        Object actual = target.request("data");

        // then
        assertEquals("data from adaptee", actual);
        verify(adaptee).specificRequest("data");
    }
}
