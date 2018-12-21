package com.anbo.juja.patterns.visitor_10.sample.garland;

import ua.com.juja.patterns.visitor.sample.garland.element.Bell;
import ua.com.juja.patterns.visitor.sample.garland.element.Color;
import ua.com.juja.patterns.visitor.sample.garland.element.Laser;
import ua.com.juja.patterns.visitor.sample.garland.element.Led;
import ua.com.juja.patterns.visitor.sample.garland.midi.Synthesizer;
import ua.com.juja.patterns.visitor.sample.garland.midi.SynthesizerImpl;
import ua.com.juja.patterns.visitor.sample.garland.music.CoolMusic;
import ua.com.juja.patterns.visitor.sample.garland.music.Music;
import ua.com.juja.patterns.visitor.sample.garland.music.RandomMusic;

import java.util.Random;

/**
 * Created by oleksandr.baglai on 22.10.2015.
 */
public class Main {

    // это наш клиент
    public static void main(String[] args) {
        // это наш синтезатор, он синглтон, помнишь?
        Synthesizer synthesizer = SynthesizerImpl.getInstance();

        // гирлянда - это контейнер элементов, который зависит от внешнего синтезатора
        Garland garland = new Garland(synthesizer);

        // мы создаем цепочку нашей цвето-музыкальной гирлянды
        // это у нас двусвязный список, что состоит из Node,
        // которые Changeable (это Element по классике),
        // но спрятано это за билдером реализованным в Garland
        // с помощью методов led() laser() и bell()
        garland.led().led().bell()
                .led().led().laser(Color.RED)
                .led().led().bell()
                .led().led().laser(Color.GREEN)
                .led().led().bell()
                .led().led().laser(Color.BLUE)
                .led().led();

        // наши посетители - алгоритмы генерации музыки
        Music randomMusic = new RandomMusic(new Random());
        Music coolMusic = new CoolMusic();

        // еще один посетитель - он все воспроизведет, что другие нагенерили
        Music player = new Player();

        // пробегаемся рандомизатором
        garland.play(randomMusic);

        // играй гармонь!
        while (true) {
            // изменяем состояние гирлянды
            // TODO попробуй тут coolMusic
            garland.play(randomMusic);
            // воспроизводим все
            garland.play(player);

            // чуть задержка
            sleep();
        }
    }

    private static void sleep() {
        System.out.println("\n--------------------");
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
