package com.anbo.juja.patterns.factoryMethod_12.sample.imageReader;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by oleksandr.baglai on 11.11.2015.
 */
// это наш Creator
public abstract class Loader {

    // это factory method
    protected abstract Image createImage(BufferedImage image);

    // a это template method :)
    // метод загрузки рисунков из файлов одинаков для всех типов
    public Image loadImage(String fileName) {
        try {
            BufferedImage image = ImageIO.read(new File(fileName));
            return createImage(image);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
