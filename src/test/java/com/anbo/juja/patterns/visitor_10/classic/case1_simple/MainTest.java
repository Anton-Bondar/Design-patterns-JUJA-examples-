package com.anbo.juja.patterns.visitor_10.classic.case1_simple;

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
        assertEquals("ConcreteVisitorC visited(1) ConcreteElementA, get something String:data\n" +
                        "ConcreteVisitorC visited(2) ConcreteElementB, get something Integer:13\n" +
                        "--------------------------------------------------------------------\n" +
                        "ConcreteVisitorD visited(3) ConcreteElementA, set something String:newData\n" +
                        "ConcreteVisitorD visited(4) ConcreteElementB, set something Integer:24\n" +
                        "--------------------------------------------------------------------\n" +
                        "ConcreteVisitorC visited(1) ConcreteElementA, get something String:newData\n" +
                        "ConcreteVisitorC visited(2) ConcreteElementB, get something Integer:24\n",
                console.getOut());
    }
}
