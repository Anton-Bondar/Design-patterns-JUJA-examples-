package com.anbo.juja.patterns.template_method_06.classic;

/**
 * Created by oleksandr.baglai on 23.09.2015.
 */
public class ConcreteClassA extends AbstractClass {

    // ���� ���� ����� � ���������� ��-��������� � ��������,
    // �� ��� �� ������ ��� ��������������
    @Override
    protected Object algorithm1() {
        return "algorithm1A";
    }

    @Override
    protected void algorithm2(Object input) {
        System.out.println("algorithm2A prints " + input);
    }

    @Override
    protected void algorithm3() {
        System.out.println("algorithm3A prints smth");
    }

    @Override
    protected Object algorithm4(Object input) {
        return "algorithm4A " + input;
    }
}
