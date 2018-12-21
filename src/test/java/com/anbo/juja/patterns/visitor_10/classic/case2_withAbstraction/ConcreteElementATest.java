package com.anbo.juja.patterns.visitor_10.classic.case2_withAbstraction;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by oleksandr.baglai on 23.10.2015.
 */
public class ConcreteElementATest {

    @Test
    public void testAccept() {
        // given
        ConcreteElementA element = new ConcreteElementA();
        Visitor visitor = mock(Visitor.class);

        // when
        element.accept(visitor);

        // then
        verify(visitor).visit(element);
    }
}
