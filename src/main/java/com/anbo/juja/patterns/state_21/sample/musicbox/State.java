package com.anbo.juja.patterns.state_21.sample.musicbox;

/**
 * Created by oleksandr.baglai on 23.02.2016.
 */
// абстракция состояния, выполнена в виде абстрактного класса
public abstract class State {

    // сохраняем ссылку на musicBox чтобы удобно было с ним работать
    MusicBox musicBox;

    // единственный конструктор
    State(MusicBox musicBox) {
        this.musicBox = musicBox;
    }

    // это реакция состояния на тот же метод шкатулки
    // каждый стейт по своему его реализует
    abstract void playMusic(String songName);

    // при изменении состояния любой стейт может что-то сделать
    void showMessage() {
        // do nothing
    }
}
