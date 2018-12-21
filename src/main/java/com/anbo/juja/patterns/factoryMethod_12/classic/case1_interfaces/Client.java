package com.anbo.juja.patterns.factoryMethod_12.classic.case1_interfaces;

/**
 * Created by oleksandr.baglai on 11.11.2015.
 */
// наш клиент
public class Client {

    // заметь, что клиент ничего не знает ни про реализацию Creator
    // ни про реализацию Product - кругом одни абстракции
    public String process(String data, Creator creator) {
        Product product = creator.factoryMethod();

        // тут может быть что угодно

        return product.process(data);
    }
}
