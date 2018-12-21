package com.anbo.juja.patterns.visitor_10.classic.case2_withAbstraction;

import org.junit.Test;
import ua.com.juja.patterns.visitor.ConsoleMock;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by oleksandr.baglai on 23.10.2015.
 */
public class MainTest {

    private ConsoleMock console = new ConsoleMock();

    @Test
    public void test() {
        // when
        Main.main(new String[0]);

        // then
        assertEquals("ConcreteVisitorC visited(1) ConcreteElementA\n" +
                        "ConcreteVisitorC visited(1) ConcreteElementAChild\n" +
                        "ConcreteVisitorC visited(2) ConcreteElementB1\n" +
                        "ConcreteVisitorC visited(2) ConcreteElementB1Child\n" +
                        "ConcreteVisitorC visited(3) ConcreteElementB2\n" +
                        "ConcreteVisitorC visited(3) ConcreteElementB2Child\n" +
                        "--------------------------------------------------------------------\n" +
                        "ConcreteVisitorD visited(4) ConcreteElementA\n" +
                        "ConcreteVisitorD visited(4) ConcreteElementAChild\n" +
                        "ConcreteVisitorD visited(5) ConcreteElementB1\n" +
                        "ConcreteVisitorD visited(5) ConcreteElementB1Child\n" +
                        "ConcreteVisitorD visited(6) ConcreteElementB2\n" +
                        "ConcreteVisitorD visited(6) ConcreteElementB2Child\n",
                console.getOut());
    }
}
