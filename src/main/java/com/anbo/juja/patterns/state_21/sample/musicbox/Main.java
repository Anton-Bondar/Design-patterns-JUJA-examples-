package com.anbo.juja.patterns.state_21.sample.musicbox;

import java.util.Arrays;

/**
 * Created by oleksandr.baglai on 23.02.2016.
 */
// класс - запускатор
public class Main {

    public static void main(String[] args) {
        // сконфигурировали музыкальную шкатулку
        MusicBox musicBox = new MusicBox(Arrays.asList(
                "Madonna - Hung Up",
                "Muse - Supermassive Black Hole",
                "Lady Gaga - Poker Face"
        ));
        // Хорошего дня!

        // дальше должно быть понятно :)

        musicBox.insertCoin(50);
        // Добавили: 50 всего на счету: 50
        // Выберите песню:
        //    Madonna - Hung Up
        //    Muse - Supermassive Black Hole
        //    Lady Gaga - Poker Face

        musicBox.playMusic("Lady Gaga - Poker Face");
        // Поиск песни: Lady Gaga - Poker Face
        // Играет: Lady Gaga - Poker Face
        // Списано: 30 всего на счету: 20
        // Денег не хватает, пополните счет!

        System.out.println("В карман: " + musicBox.getChange());
        // Сдача: 20 всего на счету: 0
        // Хорошего дня!
        // В карман: 20

        musicBox.playMusic("Madonna - Hung Up");
        // Денег не хватает, пополните счет!
        // Вы не можете выбрать песню: Madonna - Hung Up

        musicBox.insertCoin(100);
        // Добавили: 100 всего на счету: 100
        //     Выберите песню:
        //     Madonna - Hung Up
        //     Muse - Supermassive Black Hole
        //     Lady Gaga - Poker Face

        musicBox.playMusic("Madonna - Hung Up");
        // Поиск песни: Madonna - Hung Up
        // Играет: Madonna - Hung Up
        // Списано: 30 всего на счету: 70
        // Выберите песню:
        //     Madonna - Hung Up
        //     Muse - Supermassive Black Hole
        //     Lady Gaga - Poker Face

        musicBox.playMusic("Madonna - Celebration");
        // Поиск песни: Madonna - Celebration
        // Песня не найдена: Madonna - Celebration
        // Выберите песню:
        //     Madonna - Hung Up
        //     Muse - Supermassive Black Hole
        //     Lady Gaga - Poker Face

        System.out.println("В карман: " + musicBox.getChange());
        // Сдача: 70 всего на счету: 0
        // Хорошего дня!
        // В карман: 70
    }
}
