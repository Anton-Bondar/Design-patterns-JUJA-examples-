package com.anbo.juja.patterns.state_21.classic.case1_extends;

import org.junit.Test;
import ua.com.juja.patterns.objectPool.ConsoleMock;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by oleksandr.baglai on 25.02.2016.
 */
public class ContextTest {

    private ConsoleMock console = new ConsoleMock();

    @Test
    public void testRequestProcessedByState() {
        // given
        Context context = new Context();
        State state = mock(State.class);
        context.setState(state);

        // when
        context.request("data");

        // then
        verify(state).handle(context, "data");
    }

    @Test
    public void testDefaultStateIsA() {
        // given
        Context context = new Context();

        // when
        context.request("data");

        // then
        assertEquals("Set state: A\n" +
                "Handled by A: data\n" +
                "Set state: B\n", console.getOut());
    }
}
