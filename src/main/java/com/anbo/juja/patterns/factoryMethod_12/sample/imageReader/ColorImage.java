package com.anbo.juja.patterns.factoryMethod_12.sample.imageReader;

import java.awt.image.BufferedImage;

/**
 * Created by oleksandr.baglai on 11.11.2015.
 */
// это ProductB
public class ColorImage extends Image {

    public ColorImage(BufferedImage image) {
        super(image);
    }

    // тут может быть что-то полезное для работы именно с этим форматом

    // но клиент увидит только то что объявлено в Image
}
