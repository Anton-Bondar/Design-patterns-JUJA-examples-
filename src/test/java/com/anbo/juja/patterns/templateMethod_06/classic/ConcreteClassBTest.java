package com.anbo.juja.patterns.templateMethod_06.classic;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by oleksandr.baglai on 23.09.2015.
 */
// ��� �� � �� ������ �������
public class ConcreteClassBTest {

    // ��� ��� ������ �� ���� :)

    @Test
    public void test() {
        // given

        // ��� ����������� ������������� ��� ��������
        AbstractClass object = new ConcreteClassB();

        // when
        // �������� ��� ��������� ����� � �������� �������� ������
        Object result = object.templateMethod("some_data");

        // then
        // ���������, ��� �� ������ ���
        assertEquals("default_algorithm1 plus algorithm4B some_data", result);
    }
}
