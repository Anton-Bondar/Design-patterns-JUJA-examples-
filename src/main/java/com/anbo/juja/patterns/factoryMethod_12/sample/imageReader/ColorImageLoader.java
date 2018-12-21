package com.anbo.juja.patterns.factoryMethod_12.sample.imageReader;

import java.awt.image.BufferedImage;

/**
 * Created by oleksandr.baglai on 11.11.2015.
 */
// это ConcreteCreatorB
public class ColorImageLoader extends Loader {

    @Override
    protected Image createImage(BufferedImage image) {
        // он оборачивает BufferedImage в ColorImage который сохраняет его в полном цвете
        return new ColorImage(image);
    }
}
