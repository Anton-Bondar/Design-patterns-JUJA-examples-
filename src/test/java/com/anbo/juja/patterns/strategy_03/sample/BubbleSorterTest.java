package com.anbo.juja.patterns.strategy_03.sample;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * Created by oleksandr.baglai on 02.09.2015.
 */
public class BubbleSorterTest {

    @Test
    public void testSorting() {
        // given
        BubbleSorter sorter = new BubbleSorter(new Comparator() {
            public boolean compare(Object o1, Object o2) {
                return Integer.valueOf((String)o1) > Integer.valueOf((String)o2);
            }
        });

        // when
        Object[] actual = sorter.sort(new String[]{"1", "2", "4", "3", "5"});

        // then
        assertEquals("[1, 2, 3, 4, 5]", Arrays.toString(actual));
    }
}
