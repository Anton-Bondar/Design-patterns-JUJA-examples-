package com.anbo.juja.patterns.factoryMethod_12.sample.imageReader;

import java.awt.image.BufferedImage;

/**
 * Created by oleksandr.baglai on 11.11.2015.
 */
// это ConcreteCreatorA
public class GrayScaleImageLoader extends Loader {

    @Override
    protected Image createImage(BufferedImage image) {
        // он оборачивает BufferedImage в BlackAndWhiteImage,
        // который сохранит только ЧБ составляющую
        return new GrayScaleImage(image);
    }
}
