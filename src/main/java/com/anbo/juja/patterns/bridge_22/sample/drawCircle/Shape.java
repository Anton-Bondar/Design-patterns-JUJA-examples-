package com.anbo.juja.patterns.bridge_22.sample.drawCircle;

/**
 * Created by oleksandr.baglai on 30.03.2016.
 */
// это abstration - задает вторую иерархию фигур.
// эаметь, что она сама ничего не делает, а только хранит ссылку на
// implementor и делегирует хранимому объекту все действия своих наследников.
// этот класс так же может делать дополнительное полезное
// для всех наследников иерархии действие, в данном примере я ограничился методом отрисовки линий
public abstract class Shape {
    private Drawer drawer;

    protected Shape(Drawer drawer){
        this.drawer = drawer;
    }

    protected void setDot(double x, double y) {
        drawer.setPixel((int)x, (int)y);
    }

    protected void setLine(double x1, double y1, double x2, double y2) {
        double deltaX = x2 - x1;
        double deltaY = y2 - y1;
        double dx = 1;
        double dy = 1;
        if (Math.abs(deltaX) > Math.abs(deltaY)) {
            dx = deltaX/Math.abs(deltaX);
            dy = deltaY/Math.abs(deltaX);
        } else {
            dx = deltaX/Math.abs(deltaY);
            dy = deltaY/Math.abs(deltaY);
        }
        double x = x1;
        double y = y1;
        do {
            setDot(x, y);

            x += dx;
            y += dy;
        } while (x != x2 || y != y2);
    }

    public void draw() {
        drawer.paint();
    }
}
