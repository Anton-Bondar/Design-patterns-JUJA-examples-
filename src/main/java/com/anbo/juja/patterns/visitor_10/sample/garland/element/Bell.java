package com.anbo.juja.patterns.visitor_10.sample.garland.element;

import ua.com.juja.patterns.visitor.sample.garland.midi.Synthesizer;
import ua.com.juja.patterns.visitor.sample.garland.midi.SynthesizerImpl;
import ua.com.juja.patterns.visitor.sample.garland.music.Music;
import ua.com.juja.patterns.visitor.sample.garland.Node;

/**
 * Created by oleksandr.baglai on 22.10.2015.
 */
// звоночек может 1 секунду играть какую-то нотку
public class Bell extends Node {

    private Synthesizer synthesizer;
    private int frequency;

    public Bell(Synthesizer synthesizer) {
        frequency = 0;
        this.synthesizer = synthesizer;
    }

    @Override
    public void change(Music music) {
        music.affect(this);
    }

    public void tone(int frequency) {
        this.frequency = frequency;
    }

    public void beep() {
        synthesizer.tone(frequency, 1000, 100);
    }

    public int tone() {
        return frequency;
    }
}
