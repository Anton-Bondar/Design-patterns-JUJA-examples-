package com.anbo.juja.patterns.visitor_10.sample.garland.music;

import ua.com.juja.patterns.visitor.sample.garland.Node;
import ua.com.juja.patterns.visitor.sample.garland.element.Bell;
import ua.com.juja.patterns.visitor.sample.garland.element.Color;
import ua.com.juja.patterns.visitor.sample.garland.element.Laser;
import ua.com.juja.patterns.visitor.sample.garland.element.Led;

/**
 * Created by oleksandr.baglai on 22.10.2015.
 */
// цвето-мелодия, которая изменяет состояние относительно текущего
public class CoolMusic implements Music {

    // R -> G -> B -> Y -> R -> ...
    @Override
    public void affect(Led led) {
        led.setColor(led.getColor().next());
    }

    // тон повышается на 1 с каждым тактом
    @Override
    public void affect(Bell bell) {
        bell.tone(bell.tone() + 1);
    }

    // ладер то включается то выключается
    @Override
    public void affect(Laser laser) {
        laser.light(!laser.isOn());
    }
}
