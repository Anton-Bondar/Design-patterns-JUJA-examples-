package com.anbo.juja.patterns.facade_17.sample.score;

import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * Created by oleksandr.baglai on 28.12.2015.
 */
public abstract class ScoreReaderTest {

    public String getJson() {
        return "{'logs':[" +
                "{'name':'stiven',score:14}," +
                "{'name':'eva',score:17}," +
                "{'name':'stiven',score:45}," +
                "{'name':'eva',score:24}," +
                "{'name':'eva',score:52}," +
                "{'name':'bob',score:24}," +
                "{'name':'bob',score:73}," +
                "{'name':'bob',score:14}," +
                "{'name':'eva',score:67}," +
                "{'name':'stiven',score:35}," +
                "{'name':'eva',score:84}," +
                "{'name':'stiven',score:24}," +
                "]}";
    }

    protected abstract ScoreReader getScoreReader();

    @Test
    public void testGetUsers() {
        // given
        ScoreReader reader = getScoreReader();

        // when
        Set<String> users = reader.getUsers();

        // then
        assertEquals("[stiven, bob, eva]", users.toString());
    }

    @Test
    public void testGetTotalScore() {
        // given
        ScoreReader reader = getScoreReader();

        // when
        int score = reader.getTotalScore();

        // then
        assertEquals(473, score);
    }

    @Test
    public void testGetTotalScoreForUser() {
        // given
        ScoreReader reader = getScoreReader();

        // when then
        assertEquals(118, reader.getTotalScore("stiven"));
        assertEquals(111, reader.getTotalScore("bob"));
        assertEquals(244, reader.getTotalScore("eva"));
    }
}
