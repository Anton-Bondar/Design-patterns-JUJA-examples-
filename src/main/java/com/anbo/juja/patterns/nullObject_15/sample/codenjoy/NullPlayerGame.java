package com.anbo.juja.patterns.nullObject_15.sample.codenjoy;

/**
 * Created by oleksandr.baglai on 10.12.2015.
 */
class NullPlayerGame extends PlayerGame {

    // зависим от всяких объектов? передадим null-объекты!
    NullPlayerGame() {
        super(Player.NULL, Game.NULL, PlayerController.NULL, Joystick.NULL);
    }
}
