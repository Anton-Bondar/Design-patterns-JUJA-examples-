package com.anbo.juja.patterns.template_method_06.sample;

import ua.com.juja.patterns.templateMethod.sample.BubbleSorter;

/**
 * Created by oleksandr.baglai on 23.09.2015.
 */
// ��������� ������������, ������� ������ ���������� �� ������
public class CountNumbersBubbleSorter extends BubbleSorter {

    @Override
    protected boolean compare(Object o1, Object o2) {
        String s1 = o1.toString();
        String s2 = o2.toString();
        return (s1.length() - s1.replaceAll("[0-9]", "").length()) <
                (s2.length() - s2.replaceAll("[0-9]", "").length());
    }

}
