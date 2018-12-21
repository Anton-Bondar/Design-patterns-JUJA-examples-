package com.anbo.juja.patterns.nullObject_15.sample.codenjoy;

/**
 * Created by oleksandr.baglai on 10.12.2015.
 */
// координата x, y
public interface Point {

    // тоже синглтончик (смотри Game.NULL - там объяснение)
    Point NULL = new NullPoint();

    int getX();

    int getY();
}
