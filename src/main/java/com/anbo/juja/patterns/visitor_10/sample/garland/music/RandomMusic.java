package com.anbo.juja.patterns.visitor_10.sample.garland.music;

import ua.com.juja.patterns.visitor.sample.garland.element.Bell;
import ua.com.juja.patterns.visitor.sample.garland.element.Color;
import ua.com.juja.patterns.visitor.sample.garland.element.Laser;
import ua.com.juja.patterns.visitor.sample.garland.element.Led;

import java.util.Random;

/**
 * Created by oleksandr.baglai on 22.10.2015.
 */
// а это рендомная музыка, совсем рендомная
public class RandomMusic implements Music {

    private Random random;

    public RandomMusic(Random random) {
        this.random = random;
    }

    @Override
    public void affect(Led led) {
        Color[] colors = Color.values();
        Color next = colors[random.nextInt(colors.length)];
        led.setColor(next);
    }

    @Override
    public void affect(Bell bell) {
        bell.tone(random.nextInt(80) + 20);
    }

    @Override
    public void affect(Laser laser) {
        laser.light(random.nextBoolean());
    }
}
