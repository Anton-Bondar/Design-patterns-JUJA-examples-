package com.anbo.juja.patterns.facade_17.sample.score;

import java.util.*;

/**
 * Created by oleksandr.baglai on 28.12.2015.
 */
// это наш клиент, он рабоатет с json но через фасад
public class ScoreReaderWithFacade implements ScoreReader {
    private JsonObjectFacade json;

    public ScoreReaderWithFacade(String jsonString) {
        json = new JsonObjectFacade(jsonString);
    }

    @Override
    public Set<String> getUsers() {
        List<String> elements = json.getElements(String.class,
                "logs", "name", null, null);
        return new HashSet<>(elements);
    }

    @Override
    public int getTotalScore(String userName) {
        List<Integer> elements = json.getElements(Integer.class,
                "logs", "score", "name", userName);
        int result = 0;
        for (Integer score : elements ) {
            result += score;
        }
        return result;
    }

    @Override
    public int getTotalScore() {
        List<Integer> elements = json.getElements(Integer.class,
                "logs", "score", null, null);
        int result = 0;
        for (Integer score : elements ) {
            result += score;
        }
        return result;
    }

}
