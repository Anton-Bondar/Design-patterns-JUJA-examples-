package com.anbo.juja.patterns.state_21.sample.musicbox;

import org.junit.Before;
import org.junit.Test;
import ua.com.juja.patterns.objectPool.ConsoleMock;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Created by oleksandr.baglai on 24.02.2016.
 */
public class PlayingMusicStateTest {

    private ConsoleMock console = new ConsoleMock();
    private MusicBox musicBox;
    private State state;

    @Before
    public void setup() {
        // given
        musicBox = mock(MusicBox.class);
        state = new PlayingMusicState(musicBox);
    }

    @Test
    public void testPlaying() {
        // when
        state.playMusic("Music");

        // then
        assertEquals("Играет: Music\n", console.getOut());
        verify(musicBox).charge(30);
        verifyNoMoreInteractions(musicBox);
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
