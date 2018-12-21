package com.anbo.juja.patterns.factoryMethod_12.classic.case2_abstractClass;

/**
 * Created by oleksandr.baglai on 11.11.2015.
 */
// наш клиент
public class Client {

    // заметь, что клиент ничего не знает ни про реализацию Creator
    // ни про реализацию Product - кругом одни абстракции
    public String process(String data, String config, Creator creator) {
        Product product = creator.create(config);

        // тут может быть что угодно

        return product.process(data);
    }
}
