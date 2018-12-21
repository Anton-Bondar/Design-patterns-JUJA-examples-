package com.anbo.juja.patterns.template_method_06.sample2;

import ua.com.juja.patterns.templateMethod.sample2.CSVSorter;

/**
 * Created by oleksandr.baglai on 23.09.2015.
 */
// ��������� ������������, ������� ������ ���������� �� ������
// �� ���� ����������� ���������� ����������� ����� �����������
public class CountNumbersCSVSorter extends CSVSorter {

    private final String separator;

    public CountNumbersCSVSorter(String separator) {
        this.separator = separator;
    }

    @Override
    protected boolean compare(Object o1, Object o2) {
        String s1 = o1.toString();
        String s2 = o2.toString();
        return (s1.length() - s1.replaceAll("[0-9]", "").length()) <
                (s2.length() - s2.replaceAll("[0-9]", "").length());
    }

    @Override
    protected String getInputSeparator() {
        return separator;
    }

    @Override
    protected String getOutputSeparator() {
        return separator;
    }
}
