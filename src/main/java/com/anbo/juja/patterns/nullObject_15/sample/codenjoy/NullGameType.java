package com.anbo.juja.patterns.nullObject_15.sample.codenjoy;

import org.apache.commons.lang.StringUtils;

/**
 * Created by oleksandr.baglai on 10.12.2015.
 */
class NullGameType implements GameType {

    NullGameType() {
        // do nothing
    }

    @Override
    public PlayerScores getPlayerScores(int score) {
        // подсчетом очков будет заниматься null-PlayerScores
        // ты его сможешь дернуть за метод, а толку ноль
        return PlayerScores.NULL;
    }

    @Override
    public Game newGame() {
        // игру будет представлять null-Game
        // вроде как создалась новая игра, но пустышка
        return Game.NULL;
    }

    @Override
    public Parameter<Integer> getBoardSize() {
        // и размер доски можешь взять
        // получишь null-Parameter а там пусто :)
        return (Parameter<Integer>) Parameter.NULL;
    }

    @Override
    public String name() {
        // игра у нас называется ""
        return StringUtils.EMPTY;
    }

    @Override
    public Enum[] getPlots() {
        // массивы все нулевой длинны, но они есть
        return new Enum[0];
    }

    @Override
    public Settings getSettings() {
        // и настройки есть! Можно даже засетапить что-то
        // но все в пустую
        return Settings.NULL;
    }

    @Override
    public boolean isSingleBoard() {
        // игра какая? Однобордовая!
        return false;
    }

    @Override
    public void newAI(String aiName) {
        // с void методами проще
        // do nothing
    }
}
