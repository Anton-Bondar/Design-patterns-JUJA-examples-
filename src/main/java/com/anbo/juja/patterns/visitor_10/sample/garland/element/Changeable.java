package com.anbo.juja.patterns.visitor_10.sample.garland.element;

import ua.com.juja.patterns.visitor.sample.garland.music.Music;

/**
 * Created by oleksandr.baglai on 22.10.2015.
 */
// а это по классике Element -
// интерфейс должны реализовать все,
// кто хочет быть обработаным Visitor (т.е. Music)
public interface Changeable {

    void change(Music music);

}
