package com.anbo.juja.patterns.templateMethod_06.classic;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.*;

/**
 * Created by oleksandr.baglai on 23.09.2015.
 */
// �� ����� �������������� � ���������� ����������
// ��� ����� ��� �������������� ����
public class ConcreteClassATest {

    // ��� ��� ������ �� ���� :)

    @Test
    public void test() {
        // given

        // ��� ����������� ������������� ��� ��������
        AbstractClass object = new ConcreteClassA();

        // when
        // �������� ��� ��������� ����� � �������� �������� ������
        Object result = object.templateMethod("some_data");

        // then
        // ���������, ��� �� ������ ���
        assertEquals("algorithm1A plus algorithm4A some_data", result);
    }
}
