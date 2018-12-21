package com.anbo.juja.patterns.templateMethod_06.sample2;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * Created by oleksandr.baglai on 23.09.2015.
 */
public class CountNumbersCSVSorterTest {

    // � ������
    @Test
    public void testSortingInteger() {
        // given
        // �� �������������� ������� �����������
        CSVSorter sorter = new CountNumbersCSVSorter("|");

        // when
        String actual = sorter.sort("123|45|3|6|12345|456");

        // then
        assertEquals("12345|123|456|45|3|6", actual);
    }

    @Test
    public void testSortingString() {
        // given
        // �� �������������� ������� �����������
        CSVSorter sorter = new CountNumbersCSVSorter("-");

        // when
        String actual = sorter.sort("sekfhseflj-ds-sdseee-d-dsds-y");

        // then
        assertEquals("sekfhseflj-ds-sdseee-d-dsds-y", actual);
    }

    @Test
    public void testSortingBoolean() {
        // given
        // �� �������������� ������� �����������
        CSVSorter sorter = new CountNumbersCSVSorter(",");

        // when
        String actual = sorter.sort("true,true,false,true");

        // then
        assertEquals("true,true,false,true", actual);
    }
}
