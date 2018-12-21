package com.anbo.juja.patterns.builder_20.sample.windows.composite;

/**
 * Created by oleksandr.baglai on 27.10.2015.
 */

import org.apache.commons.lang3.StringUtils;

public class StubWindow extends Window {

    private char ch;
    private int width;
    private int height;

    public StubWindow(char ch, int width, int height) {
        this.ch = ch;
        this.width = width;
        this.height = height;
    }

    @Override
    public String draw() {
        String result = "";

        for (int i = 0; i < height; i++) {
            result += StringUtils.leftPad("", width, ch) + "\n";
        }

        return result;
    }

    @Override
    public int width() {
        return width;
    }

    @Override
    public int height() {
        return height;
    }
}