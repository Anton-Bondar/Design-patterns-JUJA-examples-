package com.anbo.juja.patterns.state_21.classic.case1_extends;

import org.junit.Test;
import org.mockito.ArgumentCaptor;
import ua.com.juja.patterns.objectPool.ConsoleMock;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by oleksandr.baglai on 25.02.2016.
 */
public class ConcreteStateCTest {

    private ConsoleMock console = new ConsoleMock();

    @Test
    public void testHandle() throws Exception {
        // given
        State state = new ConcreteStateC();
        Context context = mock(Context.class);

        // when
        state.handle(context, "data");

        // then
        ArgumentCaptor<State> captor = ArgumentCaptor.forClass(State.class);
        verify(context).setState(captor.capture());
        assertEquals(ConcreteStateA.class, captor.getValue().getClass());

        assertEquals("Handled by C: data\n", console.getOut());
    }
}