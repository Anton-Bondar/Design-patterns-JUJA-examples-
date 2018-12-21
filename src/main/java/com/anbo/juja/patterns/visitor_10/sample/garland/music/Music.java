package com.anbo.juja.patterns.visitor_10.sample.garland.music;

import ua.com.juja.patterns.visitor.sample.garland.element.Bell;
import ua.com.juja.patterns.visitor.sample.garland.element.Laser;
import ua.com.juja.patterns.visitor.sample.garland.element.Led;

/**
 * Created by oleksandr.baglai on 22.10.2015.
 */
// по классике это у нас Visitor
public interface Music {

    // и он может влиять на любой элемент гирлянды
    void affect(Led led);

    void affect(Bell bell);

    void affect(Laser laser);
}
