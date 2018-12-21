package com.anbo.juja.patterns.templateMethod_06.sample2;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * Created by oleksandr.baglai on 23.09.2015.
 */
// ��� ���� �� ����������� ������������ - ��� �������� �����
public class CSVSorterTest {

    @Test
    public void testSorting() {
        // given
        // �� �������������� �������� ��� ����������� �����
        CSVSorter sorter = new CSVSorter(){
            @Override
            protected String getInputSeparator() {
                return "-";
            }

            @Override
            protected String getOutputSeparator() {
                return "+";
            }

            public boolean compare(Object o1, Object o2) {
                return Integer.valueOf((String)o1) > Integer.valueOf((String)o2);
            }
        };

        // when
        // � ������
        String actual = sorter.sort("1-4-5-2-3");

        // then
        assertEquals("1+2+3+4+5", actual);
    }

    @Test
    public void testSortingWithDefaultSeparator() {
        // given
        // �� �������������� �������� ��� ����������� �����
        CSVSorter sorter = new CSVSorter(){
              public boolean compare(Object o1, Object o2) {
                return Integer.valueOf((String)o1) > Integer.valueOf((String)o2);
            }
        };

        // when
        // � ������
        String actual = sorter.sort("1,4,5,2,3");

        // then
        assertEquals("1,2,3,4,5", actual);
    }
}
