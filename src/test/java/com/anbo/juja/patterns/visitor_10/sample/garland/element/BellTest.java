package com.anbo.juja.patterns.visitor_10.sample.garland.element;

import org.junit.Before;
import org.junit.Test;
import ua.com.juja.patterns.visitor.sample.garland.midi.Synthesizer;
import ua.com.juja.patterns.visitor.sample.garland.music.Music;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

/**
 * Created by oleksandr.baglai on 23.10.2015.
 */
public class BellTest {

    private Synthesizer synthesizer;
    private Bell bell;

    @Before
    public void setup() {
        synthesizer = mock(Synthesizer.class);
        bell = new Bell(synthesizer);
    }

    @Test
    public void testChangeTone() {
        // when
        bell.tone(100);

        // then
        assertEquals(100, bell.tone());
        verifyNoMoreInteractions(synthesizer);
    }

    @Test
    public void testDefaultTone() {
        // when
        Bell bell = new Bell(synthesizer);

        // then
        assertEquals(0, bell.tone());
        verifyNoMoreInteractions(synthesizer);
    }

    @Test
    public void testBeep() {
        // given
        bell.tone(100);

        // when
        bell.beep();

        // then
        verify(synthesizer).tone(100, 1000, 100);
    }

    @Test
    public void testAffectByMusic() {
        // given
        Music music = mock(Music.class);

        // when
        bell.change(music);

        // then
        verify(music).affect(bell);
    }
}
