package com.anbo.juja.patterns.facade_17.sample.score;

/**
 * Created by oleksandr.baglai on 28.12.2015.
 */
public class ScoreReaderWithFacadeTest extends ScoreReaderTest {
    @Override
    protected ScoreReader getScoreReader() {
        return new ScoreReaderWithFacade(getJson());
    }
}
