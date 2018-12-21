package com.anbo.juja.patterns.factoryMethod_12.sample.imageReader;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertSame;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

/**
 * Created by oleksandr.baglai on 12.11.2015.
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(ImageIO.class)
public class LoaderTest {

    @Test
    public void shouldLoadImage() throws IOException {
        // given

        // исходное изображение
        final BufferedImage sourceImage = new BufferedImage(100, 100,
                BufferedImage.TYPE_INT_RGB);

        // мокаем статический класс, тестить который нам не надо
        // потому что он сохраняет все на винт, а это просто не протестишь
        PowerMockito.mockStatic(ImageIO.class);
        when(ImageIO.read(any(File.class))).thenReturn(sourceImage);

        // создаем загрузчик
        // так как класс абстрактнный нам тут надо анонимно переопределить его
        Loader loader = new Loader() {
            @Override
            protected Image createImage(BufferedImage image) {
                return new Image(sourceImage) {};
            }
        };

        // when
        // загружаем
        Image image = loader.loadImage("image.png");

        // then
        // проверяем, что созданный Image содержит исходный BufferedImage
        assertSame(sourceImage, image.getImage());
    }
}
