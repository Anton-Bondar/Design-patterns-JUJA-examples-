package com.anbo.juja.patterns.factoryMethod_12.sample.imageReader;

import java.awt.*;
import java.awt.Image;
import java.awt.image.BufferedImage;

/**
 * Created by oleksandr.baglai on 11.11.2015.
 */
// это ProductA
public class GrayScaleImage extends Image {

    public GrayScaleImage(BufferedImage image) {
        // обрати внимание тут image не сразу передается родителю
        super(toGrayScale(image));
    }

    // тут должна быть какая-то супер умная логика по переводу рисунка в ЧБ формат

    // при загрузке всего изображения надо конвертнуть image
    // этот метод мы просто добавили
    private static BufferedImage toGrayScale(BufferedImage colorImage) {
        BufferedImage grayScaleImage = new BufferedImage(colorImage.getWidth(), colorImage.getHeight(),
                BufferedImage.TYPE_BYTE_GRAY);

        Graphics graphics = grayScaleImage.getGraphics();
        graphics.drawImage(colorImage, 0, 0, Color.WHITE, null);
        graphics.dispose();

        return grayScaleImage;
    }

    // ну и каждый новый пиксель тоже
    // этот метод мы переопределяем у родителя
    @Override
    public void set(int x, int y, int rgb) {
        int r = (rgb >> 16) & 0xFF;
        int g = (rgb >> 8) & 0xFF;
        int b = (rgb & 0xFF);

        int gray = (r + g + b) / 3;

        super.set(x, y, gray);
    }

}
