package com.anbo.juja.patterns.factoryMethod_12.sample.imageReader;

import org.junit.Test;

import java.awt.image.BufferedImage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;

/**
 * Created by oleksandr.baglai on 12.11.2015.
 */
public class ColorImageLoaderTest {

    // проверяем, что загрузчик обернет исходный BufferedImage без изменений
    @Test
    public void shouldWrapImage() {
        // given
        Loader loader = new ColorImageLoader();
        BufferedImage bufferedImage = mock(BufferedImage.class);

        // when
        Image image = loader.createImage(bufferedImage);

        // then
        assertEquals(ColorImage.class, image.getClass());
        assertSame(bufferedImage, image.getImage());
    }
}
