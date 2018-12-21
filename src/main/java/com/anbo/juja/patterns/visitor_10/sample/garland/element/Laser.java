package com.anbo.juja.patterns.visitor_10.sample.garland.element;

import ua.com.juja.patterns.visitor.sample.garland.music.Music;
import ua.com.juja.patterns.visitor.sample.garland.Node;

/**
 * Created by oleksandr.baglai on 22.10.2015.
 */
// этот элемент - это лазер, цвет у него зашит, и он может только вкл/выкл
public class Laser extends Node {

    private final Color color;
    private boolean on;

    public Laser(Color color) {
        this.color = color;
        on = false;
    }

    @Override
    public void change(Music music) {
        music.affect(this);
    }

    public void light(boolean on) {
        this.on = on;
    }

    public boolean isOn() {
        return on;
    }

    public Color getColor() {
        return color;
    }
}
