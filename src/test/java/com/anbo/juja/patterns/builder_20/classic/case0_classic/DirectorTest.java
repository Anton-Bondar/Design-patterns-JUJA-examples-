package com.anbo.juja.patterns.builder_20.classic.case0_classic;

import org.junit.Test;
import org.mockito.InOrder;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Created by oleksandr.baglai on 07.02.2016.
 */
public class DirectorTest {

    // тестирует алгоритм конструирования
    @Test
    public void testConstruct() {
        // given
        Builder builder = mock(Builder.class);
        Director director = new Director(builder);

        // when
        director.construct();

        // then
        // нам важна очередность
        InOrder inOrder = inOrder(builder);

        inOrder.verify(builder).buildPart1();
        inOrder.verify(builder).buildPart2();
        inOrder.verify(builder).buildPart3();
        inOrder.verify(builder).buildPart4();
    }

    // тестируем как создается продукт
    @Test
    public void testGetProduct() {
        // given
        Builder builder = mock(Builder.class);
        Director director = new Director(builder);

        Product product = new Product();
        when(builder.getResult()).thenReturn(product);

        // when
        director.construct();
        Product actual = director.getProduct();

        // then
        assertEquals(product, actual);
    }
}
