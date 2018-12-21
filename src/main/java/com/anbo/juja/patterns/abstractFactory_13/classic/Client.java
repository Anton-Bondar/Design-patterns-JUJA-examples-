package com.anbo.juja.patterns.abstractFactory_13.classic;

/**
 * Created by oleksandr.baglai on 22.11.2015.
 */
// наш клиент
public class Client {

    // заметь, что клиент ничего не знает ни про реализацию Creator
    // ни про реализации Products - кругом одни абстракции
    public Product2 process(AbstractFactory factory) {
        Product1 product1 = factory.createProduct1();
        Product2 product2 = factory.createProduct2();
        Product3 product3 = factory.createProduct3();

        // тут может быть что угодно

        String one = product3.getOne();
        String processedOne = product1.process(one);
        product2.setOne(processedOne);

        String another = product3.getAnother();
        String processedAnother = product1.process(another);
        product2.setAnother(processedAnother);

        return product2;
    }
}
