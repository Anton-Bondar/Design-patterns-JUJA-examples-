package com.anbo.juja.patterns.visitor_10.sample.garland.midi;

import javax.sound.midi.MidiChannel;

/**
 * Created by oleksandr.baglai on 22.10.2015.
 */
// это синтезатор для игры на midi из java
// можно музыку кодить :)
public class SynthesizerImpl implements Synthesizer {

    private MidiChannel midi;
    private static final SynthesizerImpl instance = new SynthesizerImpl(new RealMidiChannelFactory());

    public SynthesizerImpl(MidiChannelFactory midiFactory) {
        this.midi = midiFactory.get();
    }

    public static SynthesizerImpl getInstance() {
        return instance;
    }

    @Override
    public void tone(final int noteNumber,
                     final int duration,
                     final int velocity)
    {
        new Thread(new Runnable() {
            @Override
            public void run() {
                midi.noteOn(noteNumber, velocity);
                sleep(duration);
                midi.noteOff(noteNumber);
            }
        }).start();
    }

    private void sleep(int длительность) {
        try {
            Thread.sleep(длительность);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
