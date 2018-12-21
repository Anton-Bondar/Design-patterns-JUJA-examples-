package com.anbo.juja.patterns.visitor_10.sample.garland;

import org.junit.Before;
import org.junit.Test;
import ua.com.juja.patterns.visitor.ConsoleMock;
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

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Created by oleksandr.baglai on 23.10.2015.
 */
public class GarlandTest {

    private ConsoleMock console = new ConsoleMock();

    @Test
    public void test() {
        // given
        Synthesizer synthesizer = mock(Synthesizer.class);

        Garland garland = new Garland(synthesizer);

        garland.led().led().bell()
                .led().led().laser(Color.RED)
                .led().led().bell()
                .led().led().laser(Color.GREEN)
                .led().led().bell()
                .led().led().laser(Color.BLUE)
                .led().led();

        Music player = new Player();

        // when
        garland.play(player);

        // then
        assertEquals("RR-RR!RR-RR!RR-RR!RR", console.getOut());
        verify(synthesizer, times(3)).tone(0, 1000, 100);
        reset(synthesizer);

        // when
        garland.play(new Music() {
            @Override
            public void affect(Led led) {
                led.setColor(Color.GREEN);
            }

            @Override
            public void affect(Bell bell) {
                bell.tone(103);
            }

            @Override
            public void affect(Laser laser) {
                laser.light(true);
            }
        });

        garland.play(player);

        // then
        assertEquals("GG+GG!GG+GG!GG+GG!GG", console.getOut());
        verify(synthesizer, times(3)).tone(103, 1000, 100);
    }
}
