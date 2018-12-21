package com.anbo.juja.patterns.visitor_10.sample.garland.midi;

/**
 * Created by oleksandr.baglai on 23.10.2015.
 */
public interface Synthesizer {
    void tone(int noteNumber,
              int duration,
              int velocity);
}
