package com.anbo.juja.patterns.builder_20.sample.windows.builder;

import ua.com.juja.patterns.builder.sample.windows.composite.HorizontalAlignment;
import ua.com.juja.patterns.builder.sample.windows.composite.StringMessage;
import ua.com.juja.patterns.builder.sample.windows.composite.VerticalAlignment;
import ua.com.juja.patterns.builder.sample.windows.composite.Window;

import java.util.Arrays;
import java.util.List;

/**
 * Created by oleksandr.baglai on 10.02.2016.
 */
public class WindowBuilder {

    private String message;
    private List<WindowBuilder> children;
    private boolean vertical;

    public static WindowBuilder window() {
        return new WindowBuilder();
    }

    public static WindowBuilder window(String message) {
        return window().message(message);
    }

    protected WindowBuilder() {
        horizontal();
    }

    protected WindowBuilder message(String message) {
        if (children != null) {
            throwError();
        }

        this.message = message;
        return this;
    }

    private void throwError() {
        throw new IllegalArgumentException("Окно может были либо контейнером либо содержать текст!");
    }

    public WindowBuilder add(WindowBuilder... children) {
        if (message != null) {
            throwError();
        }

        this.children = Arrays.asList(children);
        return this;
    }

    public WindowBuilder vertical() {
        this.vertical = true;
        return this;
    }

    public WindowBuilder horizontal() {
        this.vertical = false;
        return this;
    }

    public Window build() {
        if (message != null) {
            return createStringMessage(message);
        }

        Window root = (vertical) ? createVertical() : createHorizontal();
        if (children != null) {
            for (WindowBuilder builder : children) {
                root.add(builder.build());
            }
        }
        return root;
    }

    // а это нужно только для того, чтобы иметь возможность протестировать билдер
    // независимо от пакета window.composite
    // в тесте будем тестировать не этот класс, а анонимно занасаледованный
    // от этого класс, с переопределением этих методов
    // хотя, по хорошему, можно было бы и сделать интеграционный тест
    // что мы тоже сделаем - посмотрим что проще!

    protected Window createStringMessage(String message) {
        return new StringMessage(message);
    }

    protected Window createVertical() {
        return new VerticalAlignment();
    }

    protected Window createHorizontal() {
        return new HorizontalAlignment();
    }
}
