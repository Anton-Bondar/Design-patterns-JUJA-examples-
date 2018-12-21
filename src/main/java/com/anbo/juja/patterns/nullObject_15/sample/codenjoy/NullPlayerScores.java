package com.anbo.juja.patterns.nullObject_15.sample.codenjoy;

/**
 * Created by oleksandr.baglai on 10.12.2015.
 */
class NullPlayerScores implements PlayerScores {

    // очков сегодня не будет - все по нулям

    NullPlayerScores() {
        // do nothing
    }

    @Override
    public int getScore() {
        return 0;
    }

    @Override
    public int clear() {
        return 0;
    }

    @Override
    public void event(Object event) {
        // do nothing
    }
}
