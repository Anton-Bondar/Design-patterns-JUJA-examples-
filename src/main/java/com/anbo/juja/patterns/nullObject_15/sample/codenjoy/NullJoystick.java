package com.anbo.juja.patterns.nullObject_15.sample.codenjoy;

/**
 * Created by oleksandr.baglai on 10.12.2015.
 */
class NullJoystick implements Joystick {

    // идеальный джойстик
    // все равно что играть на ведре

    NullJoystick() {
        // do nothing
    }

    @Override
    public void down() {
        // do nothing
    }

    @Override
    public void up() {
        // do nothing
    }

    @Override
    public void left() {
        // do nothing
    }

    @Override
    public void right() {
        // do nothing
    }

    @Override
    public void act(int... p) {
        // do nothing
    }

    @Override
    public void tick() {
        // do nothing
    }
}
