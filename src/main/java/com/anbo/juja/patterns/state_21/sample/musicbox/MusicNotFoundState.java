package com.anbo.juja.patterns.state_21.sample.musicbox;

/**
 * Created by oleksandr.baglai on 23.02.2016.
 */
// состояние отвечающее за то, что музыка не найдена
public class MusicNotFoundState extends State {

    MusicNotFoundState(MusicBox musicBox) {
        super(musicBox);
    }

    @Override
    void playMusic(String songName) {
        // сообщаем об этом
        System.out.println("Песня не найдена: " + songName);

        // и предлагаем выбрать другую
        musicBox.setState(SelectMusicState.class);
    }
}
