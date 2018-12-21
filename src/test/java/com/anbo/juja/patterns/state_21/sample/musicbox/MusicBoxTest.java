package com.anbo.juja.patterns.state_21.sample.musicbox;

import org.junit.Before;
import org.junit.Test;
import ua.com.juja.patterns.objectPool.ConsoleMock;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by oleksandr.baglai on 24.02.2016.
 */
public class MusicBoxTest {

    private ConsoleMock console = new ConsoleMock();
    private MusicBox musicBox;

    @Before
    public void setup() {
        // given
        musicBox = new MusicBox(Arrays.asList("Music"));
    }

    @Test
    public void testStartState() {
        // then
        assertEquals("MusicBox[account:0, cashbox:0, " +
                "state:HaveANiceDayState, catalog:[Music]]",
                musicBox.toString());
    }

    @Test
    public void testInsertCoin_enoughForPlaying() {
        // when
        musicBox.insertCoin(50);

        // then
        assertEquals("MusicBox[account:50, cashbox:0, " +
                        "state:SelectMusicState, catalog:[Music]]",
                musicBox.toString());
    }

    @Test
    public void testInsertCoin_notEnoughForPlaying() {
        // when
        musicBox.insertCoin(29);

        // then
        assertEquals("MusicBox[account:29, cashbox:0, " +
                        "state:NotEnoughMoneyState, catalog:[Music]]",
                musicBox.toString());
    }

    @Test
    public void testInsertCoin_playMusicWhenNotEnough() {
        // when
        musicBox.playMusic("Music");

        // then
        assertEquals("Хорошего дня!\n" +
                "Денег не хватает, пополните счет!\n" +
                "Вы не можете выбрать песню: Music\n", console.getOut());

        assertEquals("MusicBox[account:0, cashbox:0, " +
                        "state:NotEnoughMoneyState, catalog:[Music]]",
                musicBox.toString());
    }

    @Test
    public void testInsertCoin_playMusicWhenEnough() {
        // when
        musicBox.insertCoin(50);
        musicBox.playMusic("Music");

        // then
        assertEquals(
                "Хорошего дня!\n" +
                "Добавили: 50 всего на счету: 50\n" +
                "Выберите песню:\n" +
                "\tMusic\n" +
                "Поиск песни: Music\n" +
                "Играет: Music\n" +
                "Списано: 30 всего на счету: 20\n" +
                "Денег не хватает, пополните счет!\n", console.getOut());

        assertEquals("MusicBox[account:20, cashbox:30, " +
                        "state:NotEnoughMoneyState, catalog:[Music]]",
                musicBox.toString());
    }

    @Test
    public void testInsertCoin_playMusicWhenEnoughAfterPlaying() {
        // when
        musicBox.insertCoin(100);
        musicBox.playMusic("Music");

        // then
        assertEquals(
                "Хорошего дня!\n" +
                "Добавили: 100 всего на счету: 100\n" +
                "Выберите песню:\n" +
                "\tMusic\n" +
                "Поиск песни: Music\n" +
                "Играет: Music\n" +
                "Списано: 30 всего на счету: 70\n" +
                "Выберите песню:\n" +
                "\tMusic\n", console.getOut());

        assertEquals("MusicBox[account:70, cashbox:30, " +
                        "state:SelectMusicState, catalog:[Music]]",
                musicBox.toString());
    }

    @Test
    public void testGetChange_when0() {
        // when
        int change = musicBox.getChange();

        // then
        assertEquals(0, change);

        assertEquals("MusicBox[account:0, cashbox:0, " +
                        "state:HaveANiceDayState, catalog:[Music]]",
                musicBox.toString());
    }

    @Test
    public void testGetChange_whenInsertCoin() {
        // given
        musicBox.insertCoin(50);

        // when
        int change = musicBox.getChange();

        // then
        assertEquals(50, change);

        assertEquals("MusicBox[account:0, cashbox:0, " +
                        "state:HaveANiceDayState, catalog:[Music]]",
                musicBox.toString());
    }

    @Test
    public void testGetChange_afterPlaying() {
        // given
        musicBox.insertCoin(50);
        musicBox.playMusic("Music");

        // when
        int change = musicBox.getChange();

        // then
        assertEquals(20, change);

        assertEquals("MusicBox[account:0, cashbox:30, " +
                        "state:HaveANiceDayState, catalog:[Music]]",
                musicBox.toString());
    }

    @Test
    public void testPlayNonExistentMusic() {
        // given
        musicBox.insertCoin(50);

        // when
        musicBox.playMusic("NonExistentMusic");

        // then
        assertEquals(
                "Хорошего дня!\n" +
                "Добавили: 50 всего на счету: 50\n" +
                "Выберите песню:\n" +
                "\tMusic\n" +
                "Поиск песни: NonExistentMusic\n" +
                "Песня не найдена: NonExistentMusic\n" +
                "Выберите песню:\n" +
                "\tMusic\n" , console.getOut());

        assertEquals("MusicBox[account:50, cashbox:0, " +
                        "state:SelectMusicState, catalog:[Music]]",
                musicBox.toString());
    }


}
