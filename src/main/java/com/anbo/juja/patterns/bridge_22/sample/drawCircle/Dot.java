package com.anbo.juja.patterns.bridge_22.sample.drawCircle;

import java.awt.*;

/**
 * Created by oleksandr.baglai on 30.03.2016.
 */
// эта фигура - точка
public class Dot extends Shape {
    private Point center;

    public Dot(Point center, Drawer drawer) {
        super(drawer);
        this.center = center;
    }

    // точка рисуется очень просто
    public void draw() {
        setDot(center.getX(), center.getY());

        super.draw();
    }
}
