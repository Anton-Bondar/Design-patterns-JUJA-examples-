package com.anbo.juja.patterns.visitor_10.sample.garland.midi;

import javax.sound.midi.MidiChannel;

/**
 * Created by oleksandr.baglai on 22.10.2015.
 */
public interface MidiChannelFactory {
    MidiChannel get();
}
