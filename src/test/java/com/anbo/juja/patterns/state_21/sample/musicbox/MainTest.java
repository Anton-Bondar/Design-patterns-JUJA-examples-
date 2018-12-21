package com.anbo.juja.patterns.state_21.sample.musicbox;

import org.junit.Test;
import ua.com.juja.patterns.objectPool.ConsoleMock;

import java.util.concurrent.ExecutionException;

import static org.junit.Assert.assertEquals;

/**
 * Created by oleksandr.baglai on 24.02.2016.
 */
public class MainTest {
    private ConsoleMock console = new ConsoleMock();

    @Test
    public void test() throws ExecutionException {
        // when
        Main.main(new String[0]);

        // then
        assertEquals("Хорошего дня!\n" +

                "Добавили: 50 всего на счету: 50\n" +

                "Выберите песню:\n" +
                "\tMadonna - Hung Up\n" +
                "\tMuse - Supermassive Black Hole\n" +
                "\tLady Gaga - Poker Face\n" +
                "Поиск песни: Lady Gaga - Poker Face\n" +
                "Играет: Lady Gaga - Poker Face\n" +
                "Списано: 30 всего на счету: 20\n" +
                "Денег не хватает, пополните счет!\n" +

                "Сдача: 20 всего на счету: 0\n" +
                "Хорошего дня!\n" +
                "В карман: 20\n" +

                "Денег не хватает, пополните счет!\n" +
                "Вы не можете выбрать песню: Madonna - Hung Up\n" +

                "Добавили: 100 всего на счету: 100\n" +

                "Выберите песню:\n" +
                "\tMadonna - Hung Up\n" +
                "\tMuse - Supermassive Black Hole\n" +
                "\tLady Gaga - Poker Face\n" +
                "Поиск песни: Madonna - Hung Up\n" +
                "Играет: Madonna - Hung Up\n" +
                "Списано: 30 всего на счету: 70\n" +

                "Выберите песню:\n" +
                "\tMadonna - Hung Up\n" +
                "\tMuse - Supermassive Black Hole\n" +
                "\tLady Gaga - Poker Face\n" +
                "Поиск песни: Madonna - Celebration\n" +
                "Песня не найдена: Madonna - Celebration\n" +

                "Выберите песню:\n" +
                "\tMadonna - Hung Up\n" +
                "\tMuse - Supermassive Black Hole\n" +
                "\tLady Gaga - Poker Face\n" +
                "Сдача: 70 всего на счету: 0\n" +
                "Хорошего дня!\n" +
                "В карман: 70\n", console.getOut());
    }
}
