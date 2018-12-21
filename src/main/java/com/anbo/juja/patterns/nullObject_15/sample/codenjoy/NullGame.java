package com.anbo.juja.patterns.nullObject_15.sample.codenjoy;

import org.apache.commons.lang.StringUtils;

/**
 * Created by oleksandr.baglai on 10.12.2015.
 */
// заметь класс у него package защищенный
class NullGame implements Game {

    // и конструктор тоже
    NullGame() {
        // do nothing
    }

    @Override
    public Joystick getJoystick() {
        // кто-то жеж может дернуть за джойстик?
        // а он у нас холостой!
        return Joystick.NULL;
    }

    @Override
    public int getMaxScore() {
        return 0; 
    }

    @Override
    public int getCurrentScore() {
        return 0; 
    }

    @Override
    public boolean isGameOver() {
        return false; 
    }

    @Override
    public void newGame() {
        // do nothing
    }

    @Override
    public String getBoardAsString() {
        return StringUtils.EMPTY; // пустая строчка, лишь бы не NPE
    }

    @Override
    public void destroy() {
        // do nothing
    }

    @Override
    public void clearScore() {
        // do nothing
    }

    @Override
    public Point getHero() {
        // и герой у нас в null позиции :)
        return Point.NULL;
    }

    @Override
    public void tick() {
        // do nothing
    }
}
