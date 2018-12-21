package com.anbo.juja.patterns.visitor_10.sample.garland.music;

import org.junit.Before;
import org.junit.Test;
import ua.com.juja.patterns.visitor.sample.garland.element.Bell;
import ua.com.juja.patterns.visitor.sample.garland.element.Color;
import ua.com.juja.patterns.visitor.sample.garland.element.Laser;
import ua.com.juja.patterns.visitor.sample.garland.element.Led;

import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyBoolean;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by oleksandr.baglai on 23.10.2015.
 */
public class RandomMusicTest {

    private Random random;
    private Music music;

    @Before
    public void setUp() {
        random = mock(Random.class);
        music = new RandomMusic(random);
    }

    @Test
    public void testAffectLed() {
        // given
        Led led = new Led();
        led.setColor(Color.values()[0]);

        int index = 2;
        when(random.nextInt(anyInt())).thenReturn(index);

        // when
        music.affect(led);

        // then
        assertEquals(Color.values()[index], led.getColor());
    }

    @Test
    public void testAffectBell() {
        // given
        Bell bell = new Bell(null);
        bell.tone(101);

        int frequency = 102;
        when(random.nextInt(anyInt())).thenReturn(frequency);

        // when
        music.affect(bell);

        // then
        assertEquals(frequency + 20, bell.tone());

        // when
        music.affect(bell);

        // then
        assertEquals(frequency + 20, bell.tone());
    }

    @Test
    public void testAffectLaser_caseOn() {
        // given
        Laser laser = new Laser(Color.RED);
        laser.light(true);

        when(random.nextBoolean()).thenReturn(false);

        // when
        music.affect(laser);

        // then
        assertEquals(false, laser.isOn());
    }

    @Test
    public void testAffectLaser_caseOff() {
        // given
        Laser laser = new Laser(Color.RED);
        laser.light(false);

        when(random.nextBoolean()).thenReturn(true);

        // when
        music.affect(laser);

        // then
        assertEquals(true, laser.isOn());
    }
}
