package com.anbo.juja.patterns.bridge_22.sample;

import org.junit.Test;
import ua.com.juja.patterns.bridge.sample.drawCircle.*;
import ua.com.juja.patterns.bridge.sample.drawCircle.Rectangle;
import ua.com.juja.patterns.bridge.sample.drawCircle.Shape;
import ua.com.juja.patterns.objectPool.ConsoleMock;

import java.awt.*;

import static org.junit.Assert.assertEquals;

/**
 * Created by indigo on 15.08.2016.
 */
public class DrawTest {
    private ConsoleMock console = new ConsoleMock();

    @Test
    public void testCircle() {
        // given
        Drawer drawer = new ConsoleDrawer();
        Shape shape = new Circle(new Point(60, 60), 50, drawer);

        // when
        shape.draw();

        // then
        assertEquals(
                "         ...........        \n" +
                "     .....          ....    \n" +
                "   ...                 ...  \n" +
                "  ..                     .. \n" +
                "  .                       ..\n" +
                "  .                        .\n" +
                "  .                       ..\n" +
                "  ..                     .. \n" +
                "   ...                  ..  \n" +
                "     ....           ....    \n" +
                "        .............       \n", console.getOut());
    }

    @Test
    public void testTriangle() {
        // given
        Drawer drawer = new ConsoleDrawer();
        Shape shape = new Triangle(
                new Point(10, 110),
                new Point(110, 110),
                new Point(60, 10),
                drawer);

        // when
        shape.draw();

        // then
        assertEquals(
                "              ..            \n" +
                "            .. ..           \n" +
                "           ..   ..          \n" +
                "          ..     ..         \n" +
                "         ..       ...       \n" +
                "       ..           ..      \n" +
                "      ..             ..     \n" +
                "     ..               ..    \n" +
                "    ..                 ...  \n" +
                "  ..                     .. \n" +
                "  ..........................\n", console.getOut());
    }

    @Test
    public void testRectangle() {
        // given
        Drawer drawer = new ConsoleDrawer();
        Shape shape = new Rectangle(
                new Point(10, 10),
                new Point(110, 110),
                drawer);

        // when
        shape.draw();

        // then
        assertEquals(
            "  ..........................\n" +
            "  .                        .\n" +
            "  .                        .\n" +
            "  .                        .\n" +
            "  .                        .\n" +
            "  .                        .\n" +
            "  .                        .\n" +
            "  .                        .\n" +
            "  .                        .\n" +
            "  .                        .\n" +
            "  ..........................\n", console.getOut());
    }

    @Test
    public void testDot() {
        // given
        Drawer drawer = new ConsoleDrawer();
        Shape shape = new Dot(
                new Point(60, 60),
                drawer);

        // when
        shape.draw();

        // then
        assertEquals(
                "               \n" +
                "               \n" +
                "               \n" +
                "               \n" +
                "               \n" +
                "              .\n", console.getOut());
    }
}
