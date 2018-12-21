package com.anbo.juja.patterns.bridge_22.classic;

import org.junit.Test;
import ua.com.juja.patterns.bridge.classic.Main;
import ua.com.juja.patterns.objectPool.ConsoleMock;

import static org.junit.Assert.assertEquals;

/**
 * Created by oleksandr.baglai on 24.02.2016.
 */
public class ConcreteImplementorATest {
    private ConsoleMock console = new ConsoleMock();

    @Test
    public void test() {
        // given
        Implementor implementor = new ConcreteImplementorA();

        // when
        implementor.operationImpl('a');

        // then
        assertEquals("a", console.getOut());
    }
}
