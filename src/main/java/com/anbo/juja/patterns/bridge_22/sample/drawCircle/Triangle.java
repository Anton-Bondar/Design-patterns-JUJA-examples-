package com.anbo.juja.patterns.bridge_22.sample.drawCircle;

import java.awt.*;
import java.awt.Shape;

/**
 * Created by oleksandr.baglai on 30.03.2016.
 */

// треугольник тоже фигура
public class Triangle extends Shape {
    private Point pt1, pt2, pt3;

    public Triangle(Point pt1, Point pt2, Point pt3, Drawer drawer) {
        super(drawer);
        this.pt1 = pt1;
        this.pt2 = pt2;
        this.pt3 = pt3;
    }

    public void draw() {
        setLine(pt1.getX(), pt1.getY(),
                pt2.getX(), pt2.getY());

        setLine(pt2.getX(), pt2.getY(),
                pt3.getX(), pt3.getY());

        setLine(pt3.getX(), pt3.getY(),
                pt1.getX(), pt1.getY());

        super.draw();
    }
}
