package com.anbo.juja.patterns.visitor_10.sample.garland.element;

import ua.com.juja.patterns.visitor.sample.garland.music.Music;
import ua.com.juja.patterns.visitor.sample.garland.Node;

/**
 * Created by oleksandr.baglai on 22.10.2015.
 */
// этот элемент - это светодиод, который может гореть разными цветами
public class Led extends Node {

    private Color color = Color.RED;

    @Override
    public void change(Music music) {
        music.affect(this);
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
}
