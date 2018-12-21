package com.anbo.juja.patterns.template_method_06.classic;

/**
 * Created by oleksandr.baglai on 23.09.2015.
 */
// ����� ������ ���� ������� ��� ����������
public abstract class AbstractClass {

    // ��� ��������� �����, � ��� ������������ ����� ���� �������������� ����������
    // ���� �� �� �����, ����� ��������� ������������� ��� - ������ final
    public final Object templateMethod(Object input) {
        Object data1 = algorithm1();
        algorithm2(input);
        algorithm3();
        Object data2 = algorithm4(input);

        return data1.toString() + " plus " + data2.toString();
    }

    // ���������� ��������� 1 ��-���������
    // ���������� ��������� �� ������, ���� �������
    protected Object algorithm1() {
        return "default_algorithm1";
    }

    // ��� ����������� ������-��������� ������ ���� ����������� ������������

    protected abstract void algorithm2(Object input);

    protected abstract void algorithm3();

    protected abstract Object algorithm4(Object input);

}
