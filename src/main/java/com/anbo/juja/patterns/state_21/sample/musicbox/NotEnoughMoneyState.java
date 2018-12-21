package com.anbo.juja.patterns.state_21.sample.musicbox;

/**
 * Created by oleksandr.baglai on 23.02.2016.
 */
// состояние отвечающее за то, что денег не хватает
public class NotEnoughMoneyState extends State {

    NotEnoughMoneyState(MusicBox musicBox) {
        super(musicBox);
    }

    @Override
    void playMusic(String songName) {
        // сообщаем об этом
        System.out.println("Вы не можете выбрать песню: " + songName);
    }

    @Override
    void showMessage() {
        System.out.println("Денег не хватает, пополните счет!");
    }
}
