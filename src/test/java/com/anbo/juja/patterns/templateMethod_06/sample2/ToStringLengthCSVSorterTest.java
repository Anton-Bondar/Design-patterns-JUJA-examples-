package com.anbo.juja.patterns.templateMethod_06.sample2;

import org.junit.Test;
import ua.com.juja.patterns.templateMethod.sample.BubbleSorter;
import ua.com.juja.patterns.templateMethod.sample.ToStringLengthBubbleSorter;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * Created by oleksandr.baglai on 23.09.2015.
 */
public class ToStringLengthCSVSorterTest {

    // given
    // �� �������������� ������� �����������
    CSVSorter sorter = new ToStringLengthCSVSorter();

    // � ������
    @Test
    public void testSortingInteger() {
        // when
        String actual = sorter.sort("123,45,3,6,12345,456");

        // then
        assertEquals("3<sep>6<sep>45<sep>123<sep>456<sep>12345",actual);
    }

    @Test
    public void testSortingString() {
        // when
        String actual = sorter.sort("sekfhseflj,ds,sdseee,d,dsds,y");

        // then
        assertEquals("d<sep>y<sep>ds<sep>dsds<sep>sdseee<sep>sekfhseflj", actual);
    }

    @Test
    public void testSortingBoolean() {
        // when
        String actual = sorter.sort("true,true,false,true");

        // then
        assertEquals("true<sep>true<sep>true<sep>false", actual);
    }
}
