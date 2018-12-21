package com.anbo.juja.patterns.templateMethod_06.classic;

import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import javax.lang.model.util.Types;

import java.util.Objects;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by oleksandr.baglai on 23.09.2015.
 */
// �� ����� �������������� � ����������� ����� ��� ������� ����������
public class AbstractClassTest {

    // ������ ��� ��� ������

    // ��� ����������� ��� �����, ����� ��������� ��� �����������
    // � ������������ ������� ���������� ������
    Object algorithm2Input = null;
    boolean callAlgorithm3 = false;
    Object algorithm4Input = null;

    @Test
    public void test() {
        // given

        // ��� ����������� ������������� ��� ��������
        AbstractClass object = new AbstractClass() {
            @Override
            protected void algorithm2(Object input) {
                algorithm2Input = input;
            }

            @Override
            protected void algorithm3() {
                callAlgorithm3 = true;
            }

            @Override
            protected Object algorithm4(Object input) {
                algorithm4Input = input;
                return "stub4";
            }
        };

        // when
        // �������� ��� ��������� ����� � �������� �������� ������
        Object result = object.templateMethod("some_data");

        // then
        // ���������, ��� �� ������ ���
        assertEquals("default_algorithm1 plus stub4", result);

        // ���������, ��� ������ � ����� algorithm2
        assertEquals("some_data", algorithm2Input);
        assertEquals("some_data", algorithm4Input);

        // ���������, ��� ��� ����� ��������� algorithm3
        assertTrue(callAlgorithm3);
    }

    // ������ �� �� �� � ������
    @Test
    public void testWithMockito() {
        // given

        // �� ������� ��� �� ������ ������ ������������ ������
        AbstractClass object = mock(AbstractClass.class);

        // �� ������������� ��� ���������
        // ��� algorithm4
        when(object.algorithm4(anyObject())).thenReturn("mocked4");
        // � ��� algorithm1 �������� ���������� ��-���������
        when(object.algorithm1()).thenCallRealMethod();

        // when
        // �������� ��� ��������� ����� � �������� �������� ������
        Object result = object.templateMethod("some_data");

        // then
        // ���������, ��� �� ������ ���
        assertEquals("default_algorithm1 plus mocked4", result);

        // ���������, ��� ������ � ����� algorithm2 � 4
        verify(object).algorithm2("some_data");
        verify(object).algorithm4("some_data");

        // ���������, ��� ��� ����� ��������� algorithm3
        verify(object).algorithm3();
    }
}
