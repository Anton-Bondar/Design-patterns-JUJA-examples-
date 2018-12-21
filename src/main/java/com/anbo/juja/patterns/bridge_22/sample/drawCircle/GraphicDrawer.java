package com.anbo.juja.patterns.bridge_22.sample.drawCircle;

import ua.com.juja.patterns.bridge.sample.drawCircle.Drawer;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Created by oleksandr.baglai on 30.03.2016.
 */
// эта реализация implementor'а умеет рисовать фигуры графически
public class GraphicDrawer implements Drawer {

    private JPanel panel;
    private List<Integer[]> dots = new LinkedList<>();

    public GraphicDrawer() {
        new JFrame() {{
            setTitle("Shapes");
            setSize(140, 160);
            setLocationRelativeTo(null);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            panel = new JPanel() {
                @Override
                public void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    Graphics2D graphics = (Graphics2D) g;

                    for (Integer[] dot : dots) {
                        graphics.fillOval(dot[0] - 1, dot[1] - 1, 3, 3);
                    }
                }
            };
            add(panel);
            setVisible(true);
        }};
    }

    @Override
    public void setPixel(int x, int y) {
        dots.add(new Integer[] {x, y});
    }

    @Override
    public void paint() {
        panel.repaint();
    }
}
