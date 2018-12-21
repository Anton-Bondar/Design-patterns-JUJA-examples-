package com.anbo.juja.patterns.bridge_22.classic;

import org.junit.Test;
import org.mockito.InOrder;

import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by indigo on 15.08.2016.
 */
public class RefinedAbstractionCTest {

    @Test
    public void testBoolean() {
        // given 
        Implementor implementor = mock(Implementor.class);
        Abstraction abstraction = new RefinedAbstractionC(implementor);

        // when
        abstraction.operation(true);

        // then
        InOrder inOrder = inOrder(implementor);
        inOrder.verify(implementor).operationImpl('t');
        inOrder.verify(implementor).operationImpl('r');
        inOrder.verify(implementor).operationImpl('u');
        inOrder.verify(implementor).operationImpl('e');
    }

    @Test
    public void testString() {
        // given
        Implementor implementor = mock(Implementor.class);
        Abstraction abstraction = new RefinedAbstractionC(implementor);

        // when
        abstraction.operation("string");

        // then
        InOrder inOrder = inOrder(implementor);
        inOrder.verify(implementor).operationImpl('s');
        inOrder.verify(implementor).operationImpl('t');
        inOrder.verify(implementor).operationImpl('r');
        inOrder.verify(implementor).operationImpl('i');
        inOrder.verify(implementor).operationImpl('n');
        inOrder.verify(implementor).operationImpl('g');
    }

    @Test
    public void testInt() {
        // given
        Implementor implementor = mock(Implementor.class);
        Abstraction abstraction = new RefinedAbstractionC(implementor);

        // when
        abstraction.operation(16);

        // then
        InOrder inOrder = inOrder(implementor);
        inOrder.verify(implementor).operationImpl('1');
        inOrder.verify(implementor).operationImpl('6');
    }

    @Test
    public void testChar() {
        // given
        Implementor implementor = mock(Implementor.class);
        Abstraction abstraction = new RefinedAbstractionC(implementor);

        // when
        abstraction.operation('c');

        // then
        InOrder inOrder = inOrder(implementor);
        inOrder.verify(implementor).operationImpl('c');
    }
}
