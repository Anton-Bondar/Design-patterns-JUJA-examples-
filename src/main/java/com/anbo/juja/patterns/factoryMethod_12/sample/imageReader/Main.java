package com.anbo.juja.patterns.factoryMethod_12.sample.imageReader;

/**
 * Created by oleksandr.baglai on 11.11.2015.
 */
// класс-запускатор
public class Main {

    public static void main(String[] args) {
        Loader loader = new GrayScaleImageLoader();
//        Loader loader = new ColorImageLoader();

        // наш клиент
        Client client = new Client();

        // делаем с рисунком, что там надо
        client.process(Main.class.getResource("/uml1.png").getPath(), loader);
    }
}
