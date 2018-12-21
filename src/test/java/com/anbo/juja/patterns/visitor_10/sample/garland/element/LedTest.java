package com.anbo.juja.patterns.visitor_10.sample.garland.element;

import org.junit.Before;
import org.junit.Test;
import ua.com.juja.patterns.visitor.sample.garland.music.Music;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by oleksandr.baglai on 23.10.2015.
 */
public class LedTest {

    private Music music;

    @Before
    public void setup() {
        music = mock(Music.class);
    }

    @Test
    public void testDefaultColor() {
        // given
        Led led = new Led();

        // when
        Color color = led.getColor();

        // then
        assertEquals(Color.RED, color);
    }

    @Test
    public void testSetColor() {
        // given
        Led led = new Led();

        // when
        led.setColor(Color.BLUE);

        // then
        Color color = led.getColor();
        assertEquals(Color.BLUE, color);
    }

    @Test
    public void testAffectByMusic() {
        // given
        Led led = new Led();

        // when
        led.change(music);

        // then
        verify(music).affect(led);
    }
}
