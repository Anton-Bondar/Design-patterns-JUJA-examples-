package com.anbo.juja.patterns.immutable_16.sample.codenjoy;

/**
 * каждый объект на поле имеет свои координаты.
 * этот класс обычно используется для указания координат или как родитель.
 * может использоваться в коллекциях.
 */
public class Point {
    protected int x;
    protected int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point(Point point) {
        this(point.getX(), point.getY());
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void move(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void move(Point pt) {
        this.x = pt.getX();
        this.y = pt.getY();
    }

    public Point copy() {
        return new Point(this);
    }

    public void change(Point delta) {
        x += delta.getX();
        y += delta.getY();
    }

    public boolean itsMe(Point pt) {
        return itsMe(pt.getX(), pt.getY());
    }

    public boolean itsMe(int x, int y) {
        return this.x == x && this.y == y;
    }

    public boolean isOutOf(int size) {
        return isOutOf(0, 0, size);
    }

    public boolean isOutOf(int dw, int dh, int size) {
        return x < dw || y < dh || y > size - 1 - dh || x > size - 1 - dw;
    }

    public double distance(Point other) {
        return Math.sqrt((x - other.getX())*(x - other.getX()) + (y - other.getY())*(y - other.getY()));
    }

    public int hashCode() {
        return x*1000 + y;
    }

    public String toString() {
        return String.format("[%s,%s]", x, y);
    }

    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }

        if (!(o instanceof Point)) {
            return false;
        }

        Point p = (Point)o;

        return (p.x == x && p.y == y);
    }


}
