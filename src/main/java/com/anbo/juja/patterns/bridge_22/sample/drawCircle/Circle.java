package com.anbo.juja.patterns.bridge_22.sample.drawCircle;

import java.awt.*;
import java.awt.Shape;

/**
 * Created by oleksandr.baglai on 30.03.2016.
 */

// круг является фигурой
public class Circle extends Shape {
    // определяется центром и радиусом
    private Point center;
    private int radius;

    public Circle(Point center, int radius, Drawer drawer) {
        super(drawer);
        this.center = center;
        this.radius = radius;
    }

    // у круга хитрый алгоритм рисования
    // thanks to https://rosettacode.org/wiki/Bitmap/Midpoint_circle_algorithm#Java
    public void draw() {
        double d = (5 - radius * 4)/4;
        double x = 0;
        double y = radius;
        double cx = center.getX();
        double cy = center.getY();

        do {
            setDot(cx + x, cy + y);
            setDot(cx + x, cy - y);
            setDot(cx - x, cy + y);
            setDot(cx - x, cy - y);
            setDot(cx + y, cy + x);
            setDot(cx + y, cy - x);
            setDot(cx - y, cy + x);
            setDot(cx - y, cy - x);
            if (d < 0) {
                d += 2 * x + 1;
            } else {
                d += 2 * (x - y) + 1;
                y--;
            }
            x++;
        } while (x <= y);

        super.draw();
    }
}
