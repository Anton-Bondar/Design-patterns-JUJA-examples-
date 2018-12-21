package com.anbo.juja.patterns.bridge_22.sample.drawCircle;

/**
 * Created by oleksandr.baglai on 30.03.2016.
 */
// наш implementor - задает первую иерархию рисователей,
// на базе которой будет построена вторая иерархия - фигуры.
public interface Drawer {

    // у него примитивные операции - установить тот или иной пиксель
    void setPixel(int x1, int y1);

    // а потом отрисовать всю картинку целиком
    void paint();

}
