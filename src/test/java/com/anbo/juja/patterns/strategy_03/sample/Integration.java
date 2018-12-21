package com.anbo.juja.patterns.strategy_03.sample;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * Created by oleksandr.baglai on 02.09.2015.
 */
public class Integration {

    @Test
    public void testSorting_withFirstLetterComparator() {
        // given
        BubbleSorter sorter = new BubbleSorter(new FirstLetterComparator());

        // when
        Object[] actual = sorter.sort(new Object[]{"122233", 32523, true, 5.8, "5"});

        // then
        assertEquals("[122233, 32523, 5.8, 5, true]", Arrays.toString(actual));
    }

    @Test
    public void testSorting_withToStringLengthComparator() {
        // given
        BubbleSorter sorter = new BubbleSorter(new ToStringLengthComparator());

        // when
        Object[] actual = sorter.sort(new Object[]{"122233", 32523, true, 5.8, "5"});

        // then
        assertEquals("[5, 5.8, true, 32523, 122233]", Arrays.toString(actual));
    }
}
