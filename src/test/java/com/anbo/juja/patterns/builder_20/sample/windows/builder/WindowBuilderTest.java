package com.anbo.juja.patterns.builder_20.sample.windows.builder;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;
import ua.com.juja.patterns.builder.sample.windows.composite.Window;

import static junit.framework.Assert.assertEquals;
import static junit.framework.TestCase.assertSame;
import static org.junit.Assert.fail;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

/**
 * Created by oleksandr.baglai on 10.02.2016.
 */
// юнит тест на билдер, тестирует только билдер
// без реализации windows.composite
// читабельность и понимабельность тестов стремится к нулю :)
// зато unit! написать такой тест не сложно,
// но вот поддерживать - mock hell!
public class WindowBuilderTest {

    private WindowBuilder builder;

    @Before
    public void setup() {
        builder = spy(WindowBuilder.class);
    }

    @Test
    public void testMessage() {
        // given
        Window stringMessage = mock(Window.class);
        when(builder.createStringMessage(anyString())).thenReturn(stringMessage);

        // when
        Window window = builder.message("message").build();

        // then
        verify(builder).createStringMessage("message");
        assertSame(stringMessage, window);
    }

    @Test
    public void testAddVertical() {
        // given
        Window vertical = mock(Window.class);
        when(builder.createVertical()).thenReturn(vertical);

        Window  child = mock(Window.class);
        WindowBuilder builderChild = spy(WindowBuilder.class);
        when(builderChild.build()).thenReturn(child);

        // when
        Window window = builder.add(builderChild).vertical().build();

        // then
        verify(builder).createVertical();
        verify(vertical).add(child);
        assertSame(vertical, window);
    }

    @Test
    public void testAddHorizontal() {
        // given
        Window  horizontal = mock(Window.class);
        when(builder.createHorizontal()).thenReturn(horizontal);

        Window  child = mock(Window.class);
        WindowBuilder builderChild = spy(WindowBuilder.class);
        when(builderChild.build()).thenReturn(child);

        // when
        Window window = builder.add(builderChild).horizontal().build();

        // then
        verify(builder).createHorizontal();
        verify(horizontal).add(child);
        assertSame(horizontal, window);
    }

    @Test
    public void testAddHorizontalTwice() {
        // given
        Window  horizontal = mock(Window.class);
        when(builder.createHorizontal()).thenReturn(horizontal);

        Window child1 = mock(Window.class);
        Window child2 = mock(Window.class);
        WindowBuilder builderChild = spy(WindowBuilder.class);
        when(builderChild.build()).thenReturn(child1, child2);

        // when
        Window window =
                builder.add(builderChild, builderChild)
                    .horizontal().build();

        // then
        InOrder inOrder = inOrder(builder, horizontal);

        inOrder.verify(builder).createHorizontal();

        inOrder.verify(horizontal).add(child1);
        inOrder.verify(horizontal).add(child2);

        assertSame(horizontal, window);
    }

    @Test
    public void testErrorWhenMessageAndChild() {
        // given
        WindowBuilder builderChild = spy(WindowBuilder.class);

        try {
            builder.message("message").add(builderChild);

            fail("expected exception");
        } catch (IllegalArgumentException e) {
            assertEquals("Окно может были либо контейнером либо содержать текст!", e.getMessage());
        }
    }

    @Test
    public void testErrorWhenChildAndMessage() {
        // given
        WindowBuilder builderChild = spy(WindowBuilder.class);

        try {
            builder.add(builderChild).message("message");

            fail("expected exception");
        } catch (IllegalArgumentException e) {
            assertEquals("Окно может были либо контейнером либо содержать текст!", e.getMessage());
        }
    }

    @Test
    public void testFactoryWindow() {
        // given when then
        assertEquals(WindowBuilder.class, WindowBuilder.window().getClass());
    }

    @Test
    public void testFactoryWindowWithMessage() {
        // given when
        WindowBuilder builder = WindowBuilder.window("message");

        // then
        assertEquals(WindowBuilder.class, builder.getClass());
        assertEquals(
                "┌───────┐\n" +
                "│message│\n" +
                "└───────┘\n", builder.build().draw());
    }
}
