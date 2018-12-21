package com.anbo.juja.patterns.template_method_06.sample;

/**
 * Created by oleksandr.baglai on 23.09.2015.
 */
// ��� ���� ��������� ����������, ��� ��������� ����������
public class FirstLetterBubbleSorter extends BubbleSorter {

    @Override
    protected boolean compare(Object o1, Object o2) {
        return o1.toString().charAt(0) > o2.toString().charAt(0);
    }
}
