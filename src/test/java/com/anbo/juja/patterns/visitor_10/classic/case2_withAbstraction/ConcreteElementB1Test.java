package com.anbo.juja.patterns.visitor_10.classic.case2_withAbstraction;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by oleksandr.baglai on 23.10.2015.
 */
public class ConcreteElementB1Test {

    @Test
    public void testAccept() {
        // given
        ConcreteElementB1 element = new ConcreteElementB1();
        Visitor visitor = mock(Visitor.class);

        // when
        element.accept(visitor);

        // then
        verify(visitor).visit(element);
    }
}
