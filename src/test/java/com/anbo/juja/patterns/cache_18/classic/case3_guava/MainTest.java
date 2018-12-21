package com.anbo.juja.patterns.cache_18.classic.case3_guava;

import org.junit.Test;
import ua.com.juja.patterns.caching.ConsoleMock;

import java.util.concurrent.ExecutionException;

import static org.junit.Assert.assertEquals;

/**
 * Created by oleksandr.baglai on 11.01.2016.
 */
public class MainTest {
    ConsoleMock console = new ConsoleMock();

    @Test
    public void test() throws ExecutionException {
        // when
        Main.main(new String[0]);

        // then
        assertEquals("Created Resource:10\n" +
                "Get Resource:10\n" +
                "Get Resource:10\n" +
                "Created Resource:11\n" +
                "Get Resource:11\n" +
                "Created Resource:12\n" +
                "Get Resource:12\n" +
                "Get Resource:10\n" +
                "Created Resource:13\n" +
                "Get Resource:13\n" +
                "Created Resource:14\n" +
                "Removing Resource:11\n" +
                "Get Resource:14\n" +
                "Get Resource:10\n", console.getOut());
    }
}
