package com.anbo.juja.patterns.state_21.sample.musicbox;

import org.junit.Before;
import org.junit.Test;
import ua.com.juja.patterns.objectPool.ConsoleMock;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

/**
 * Created by oleksandr.baglai on 24.02.2016.
 */
public class MusicNotFoundStateTest {

    private ConsoleMock console = new ConsoleMock();
    private MusicBox musicBox;
    private State state;

    @Before
    public void setup() {
        // given
        musicBox = mock(MusicBox.class);
        state = new MusicNotFoundState(musicBox);
    }

    @Test
    public void testMusicNotFound() {
        // when
        state.playMusic("Music");

        // then
        assertEquals("Песня не найдена: Music\n", console.getOut());
        verify(musicBox).setState(SelectMusicState.class);
    }

    @Test
    public void testShowMessage() {
        // when
        state.showMessage();

        // then
        assertEquals("", console.getOut());
        verifyNoMoreInteractions(musicBox);
    }

}
