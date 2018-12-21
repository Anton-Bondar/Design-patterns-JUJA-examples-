package com.anbo.juja.patterns.nullObject_15.sample.codenjoy;

/**
 * Created by oleksandr.baglai on 10.12.2015.
 */
// а это джойстик, все чем мы хотим управлять должно реализовать это
public interface Joystick extends Tickable {

    // тоже синглтончик (смотри Game.NULL - там объяснение)
    Joystick NULL = new NullJoystick();

    void down();

    void up();

    void left();

    void right();

    void act(int... p);
}
