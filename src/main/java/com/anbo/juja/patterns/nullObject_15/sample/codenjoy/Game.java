package com.anbo.juja.patterns.nullObject_15.sample.codenjoy;

/**
 * Created by oleksandr.baglai on 10.12.2015.
 */
// абстракция определяющая игру игрока
public interface Game extends Tickable {

    // тут сразу же сделали синглтончиком null объект
    // ну чтобы Game.NULL, а не какое-то там new NullGame()
    // потому что new NullGame() != new NullGame()
    // а вот Game.NULL == Game.NULL что удобно при проверках
    Game NULL = new NullGame();

    Joystick getJoystick();

    int getMaxScore();

    int getCurrentScore();

    boolean isGameOver();

    void newGame();

    String getBoardAsString();

    void destroy();

    void clearScore();

    Point getHero();
}
