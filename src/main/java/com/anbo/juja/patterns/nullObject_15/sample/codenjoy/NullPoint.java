package com.anbo.juja.patterns.nullObject_15.sample.codenjoy;

/**
 * Created by oleksandr.baglai on 10.12.2015.
 */
class NullPoint implements Point {

    // координаты где-то за пределом борды
    // в антипространстве

    @Override
    public int getX() {
        return -1;
    }

    @Override
    public int getY() {
        return -1;
    }
}
