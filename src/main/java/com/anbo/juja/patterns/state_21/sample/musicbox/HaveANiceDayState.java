package com.anbo.juja.patterns.state_21.sample.musicbox;

/**
 * Created by oleksandr.baglai on 24.02.2016.
 */
public class HaveANiceDayState extends State {

    HaveANiceDayState(MusicBox musicBox) {
        super(musicBox);
    }

    @Override
    void playMusic(String songName) {
        musicBox.checkIsEnough();
        musicBox.playMusic(songName);
    }

    @Override
    void showMessage() {
        System.out.println("Хорошего дня!");
    }
}
