package com.anbo.juja.patterns.simpleFactory_14.classic.case2_inheritance;

/**
 * Created by oleksandr.baglai on 30.11.2015.
 */
// простая фабрика, продуцирующая продукт на основе типа
public class ProductFactory {

    // обрати внимание - тут static
    public static AbstractProduct createProduct(String type) {
        if (type.equals("A")) {
            return new ConcreteProductA();
        }

        // можно было else if но оно некрасиво сливается
        if (type.equals("B")) {
            return new ConcreteProductB();
        }

        throw new UnsupportedOperationException("Unexpected type: " + type);
    }

    // но все могло быть и так
    // public static Product createProduct() {
    //    return new ConcreteProductA();
    // }
}
