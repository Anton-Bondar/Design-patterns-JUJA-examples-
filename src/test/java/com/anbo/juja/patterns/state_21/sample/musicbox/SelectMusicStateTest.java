package com.anbo.juja.patterns.state_21.sample.musicbox;

import org.junit.Before;
import org.junit.Test;
import ua.com.juja.patterns.objectPool.ConsoleMock;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

/**
 * Created by oleksandr.baglai on 24.02.2016.
 */
public class SelectMusicStateTest {

    private ConsoleMock console = new ConsoleMock();

    private MusicBox musicBox;
    private State state;

    @Before
    public void setup() {
        // given
        musicBox = mock(MusicBox.class);
        state = new SelectMusicState(musicBox);

        when(musicBox.contains("Non Existent Music")).thenReturn(false);
        when(musicBox.contains("Existent Music")).thenReturn(true);
    }


    @Test
    public void testMusicDoesNotExists() {
        // when
        state.playMusic("Non Existent Music");

        // then
        verify(musicBox).contains("Non Existent Music");
        verify(musicBox).setState(MusicNotFoundState.class);
        verify(musicBox).playMusic("Non Existent Music");
    }

    @Test
    public void testMusicExists() {
        // when
        state.playMusic("Existent Music");

        // then
        verify(musicBox).contains("Existent Music");
        verify(musicBox).setState(PlayingMusicState.class);
        verify(musicBox).playMusic("Existent Music");
    }

    @Test
    public void testShowMessage() {
        // given
        when(musicBox.getCatalog()).thenReturn(Arrays.asList("Music1", "Music2"));

        // when
        state.showMessage();

        // then
        assertEquals("Выберите песню:\n" +
                "\tMusic1\n" +
                "\tMusic2\n", console.getOut());
        verify(musicBox).getCatalog();
        verifyNoMoreInteractions(musicBox);
    }
}
