package com.anbo.juja.patterns.bridge_22.sample.drawCircle;

import java.awt.*;
import java.awt.Shape;

/**
 * Created by oleksandr.baglai on 30.03.2016.
 */
// прямоугольник тоже фигура
public class Rectangle extends Shape {
    private Point pt1, pt2;

    public Rectangle(Point pt1, Point pt2, Drawer drawer) {
        super(drawer);
        this.pt1 = pt1;
        this.pt2 = pt2;
    }

    public void draw() {
        setLine(pt1.getX(), pt1.getY(),
                pt1.getX(), pt2.getY());

        setLine(pt1.getX(), pt2.getY(),
                pt2.getX(), pt2.getY());

        setLine(pt2.getX(), pt2.getY(),
                pt2.getX(), pt1.getY());

        setLine(pt2.getX(), pt1.getY(),
                pt1.getX(), pt1.getY());

        super.draw();
    }
}
