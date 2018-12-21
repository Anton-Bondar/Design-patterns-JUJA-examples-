package com.anbo.juja.patterns.nullObject_15.sample.codenjoy;

/**
 * Created by oleksandr.baglai on 10.12.2015.
 */
// а тут сервис подсчета очков
public interface PlayerScores {

    // тоже синглтончик (смотри Game.NULL - там объяснение)
    PlayerScores NULL = new NullPlayerScores();

    int getScore();

    int clear();

    void event(Object event);
}
