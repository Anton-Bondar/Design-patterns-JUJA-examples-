package com.anbo.juja.patterns.bridge_22.classic;

import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import ua.com.juja.patterns.objectPool.ConsoleMock;

import javax.speech.AudioException;
import javax.speech.EngineException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Created by oleksandr.baglai on 24.02.2016.
 */
public class ConcreteImplementorBTest {

    @Test
    public void test() throws Exception {
        // given
        SpeechUtils speechUtils = mock(SpeechUtils.class);
        Implementor implementor = new ConcreteImplementorB(speechUtils);
        reset(speechUtils);

        doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocationOnMock) throws Throwable {
                Thread.sleep(500);
                return null;
            }
        }).when(speechUtils).doSpeak(anyString());

        // when
        implementor.operationImpl('a');
        implementor.operationImpl('b');
        implementor.operationImpl('c');

        // then
        Thread.sleep(4000);
        verify(speechUtils).doSpeak("a");
        verify(speechUtils).doSpeak("b");
        verify(speechUtils).doSpeak("c");
    }
}
