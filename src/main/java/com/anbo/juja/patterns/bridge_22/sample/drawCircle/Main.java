package com.anbo.juja.patterns.bridge_22.sample.drawCircle;

import java.awt.*;

/**
 * Created by oleksandr.baglai on 30.03.2016.
 */
public class Main {
    public static void main(String[] args) {
        // выбираем тот или иной Implementor
//        Drawer drawer = new GraphicDrawer();
        Drawer drawer = new ConsoleDrawer();

        // выбираем ту или иную фигуру
        Shape shape = new Dot(
                new Point(60, 60),
                drawer);

//        Shape shape = new Circle(
//                new Point(60, 60), 50,
//                drawer);

//        Shape shape = new Triangle(
//                new Point(10, 110),
//                new Point(110, 110),
//                new Point(60, 10),
//                drawer);

//        Shape shape = new Rectangle(
//                new Point(10, 10),
//                new Point(110, 110),
//                drawer);

        // рисуем фигуру
        shape.draw();
    }
}
