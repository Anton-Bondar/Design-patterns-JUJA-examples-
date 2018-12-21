package com.anbo.juja.patterns.visitor_10.sample.garland.element;

/**
 * Created by oleksandr.baglai on 22.10.2015.
 */
// енумчик из разных цветов
public enum Color {

    RED, GREEN, BLUE, YELLOW;

    public Color next() {
        switch (this) {
            case RED: return GREEN;
            case GREEN: return BLUE;
            case BLUE: return YELLOW;
            case YELLOW: return RED;
        }
        throw new UnsupportedOperationException("Ты добавил новый цвет, добавь его в next()!");
    }
}
