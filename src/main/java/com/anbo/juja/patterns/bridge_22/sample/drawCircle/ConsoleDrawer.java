package com.anbo.juja.patterns.bridge_22.sample.drawCircle;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by oleksandr.baglai on 30.03.2016.
 */
// эта реализация implementor'а умеет рисовать фигуры в консоли
public class ConsoleDrawer implements Drawer {

    private List<Integer[]> dots = new LinkedList<>();

    @Override
    public void setPixel(int x, int y) {
        dots.add(new Integer[] {x, y});
    }

    @Override
    public void paint() {
        int width = 0;
        int height = 0;
        double scaleX = 0.5/2;
        double scaleY = 0.2/2;

        for (Integer[] dot : dots) {
            dot[0] = (int)Math.round(dot[0] * scaleX);
            dot[1] = (int)Math.round(dot[1] * scaleY);
        }

        for (Integer[] dot : dots) {
            width = Math.max(width, dot[0]);
            height = Math.max(height, dot[1]);
        }

        char[][] chars = new char[width][height];
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                chars[x][y] = ' ';
            }
        }
        for (Integer[] dot : dots) {
            chars[dot[0] - 1][dot[1] - 1] = '.';
        }
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                System.out.print(chars[x][y]);
            }
            System.out.print('\n');
        }
    }
}
