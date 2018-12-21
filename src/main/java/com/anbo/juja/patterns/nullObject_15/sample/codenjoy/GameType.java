package com.anbo.juja.patterns.nullObject_15.sample.codenjoy;

/**
 * Created by oleksandr.baglai on 10.12.2015.
 */
// абстракция типа игры
public interface GameType {

    // тоже синглтончик (смотри Game.NULL - там объяснение)
    GameType NULL = new NullGameType();

    PlayerScores getPlayerScores(int score);

    Game newGame();

    Parameter<Integer> getBoardSize();

    String name();

    Enum[] getPlots();

    Settings getSettings();

    boolean isSingleBoard();

    void newAI(String aiName);
}



















