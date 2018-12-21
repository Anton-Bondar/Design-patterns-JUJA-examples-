package com.anbo.juja.patterns.visitor_10.classic.case1_simple;

import org.junit.Test;
import ua.com.juja.patterns.visitor.ConsoleMock;

import static org.junit.Assert.assertEquals;

/**
 * Created by oleksandr.baglai on 23.10.2015.
 */
public class ConcreteVisitorCTest {

    private ConsoleMock console = new ConsoleMock();

    @Test
    public void testVisitConcreteElementA() {
        // given
        ConcreteElementA element = new ConcreteElementA("qwe");
        ConcreteVisitorC visitor = new ConcreteVisitorC();

        // when
        visitor.visit(element);

        // then
        assertEquals("ConcreteVisitorC visited(1) ConcreteElementA, get something String:qwe\n", console.getOut());
    }

    @Test
    public void testVisitConcreteElementB() {
        // given
        ConcreteElementB element = new ConcreteElementB(13);
        ConcreteVisitorC visitor = new ConcreteVisitorC();

        // when
        visitor.visit(element);

        // then
        assertEquals("ConcreteVisitorC visited(2) ConcreteElementB, get something Integer:13\n", console.getOut());
    }
}
