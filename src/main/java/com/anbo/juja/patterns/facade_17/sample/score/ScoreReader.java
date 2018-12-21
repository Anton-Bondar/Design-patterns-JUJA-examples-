package com.anbo.juja.patterns.facade_17.sample.score;

import java.util.Set;

/**
 * Created by oleksandr.baglai on 28.12.2015.
 */
public interface ScoreReader {
    Set<String> getUsers();

    int getTotalScore(String userName);

    int getTotalScore();
}
