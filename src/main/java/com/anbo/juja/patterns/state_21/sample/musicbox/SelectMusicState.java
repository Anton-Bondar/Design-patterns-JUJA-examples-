package com.anbo.juja.patterns.state_21.sample.musicbox;

/**
 * Created by oleksandr.baglai on 23.02.2016.
 */
// состояние отвечающее за выбор музыки
public class SelectMusicState extends State {

    SelectMusicState(MusicBox musicBox) {
        super(musicBox);
    }

    @Override
    void playMusic(String songName) {
        System.out.println("Поиск песни: " + songName);

        if (musicBox.contains(songName)) {
            musicBox.setState(PlayingMusicState.class);
        } else {
            musicBox.setState(MusicNotFoundState.class);
        }
        // тут важно, мы не только поменяли стейт,
        // но и попросили его доделать начатое тут
        musicBox.playMusic(songName);
    }

    @Override
    void showMessage() {
        System.out.println("Выберите песню:");
        for (String name : musicBox.getCatalog()) {
            System.out.println("\t" + name);
        }
    }
}
