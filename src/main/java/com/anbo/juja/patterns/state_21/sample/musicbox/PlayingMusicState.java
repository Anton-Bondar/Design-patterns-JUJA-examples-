package com.anbo.juja.patterns.state_21.sample.musicbox;

/**
 * Created by oleksandr.baglai on 23.02.2016.
 */
// состояние отвечающее за проигрывание музыки
public class PlayingMusicState extends State {

    PlayingMusicState(MusicBox musicBox) {
        super(musicBox);
    }

    @Override
    void playMusic(String songName) {
        System.out.println("Играет: " + songName);
        play();
        // тут снимаем средства
        musicBox.charge(30);
    }

    // это как ты понял - бутафория :)
    private void play() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
