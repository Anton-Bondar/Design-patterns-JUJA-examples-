package com.anbo.juja.patterns.immutable_16.sample.codenjoy;

// сделали класс final
public final class ImmutablePoint {

    // поля скрыли
    private final int x;
    private final int y;

    public ImmutablePoint(int x, int y) {
        this.x = x;
        this.y = y;
    }
 
    public ImmutablePoint(ImmutablePoint point) {
        this(point.getX(), point.getY());
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    // метод move не меняет координат текущего объекта
    // и по хорошему должен быть удален
    // public ImmutablePoint move(int x, int y) {
    //    return new ImmutablePoint(x, y);
    // }

    // так же и тут
    // public ImmutablePoint move(ImmutablePoint pt) {
    //    return new ImmutablePoint(pt);
    // }

    public ImmutablePoint copy() {
        return new ImmutablePoint(this);
    }

    // метод change уже несколько более полезен, его оставим
    // но он будет возвращать новый объект!
    public ImmutablePoint change(ImmutablePoint delta) {
        return new ImmutablePoint(x + delta.getX(), y + delta.getY());
    }

    // дальше все безопасно - ридоноли и не меняет состояния

    public boolean itsMe(ImmutablePoint pt) {
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

    public double distance(ImmutablePoint other) {
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

        if (!(o instanceof ImmutablePoint)) {
            return false;
        }

        ImmutablePoint p = (ImmutablePoint)o;

        return (p.x == x && p.y == y);
    }


}
