package com.anbo.juja.patterns.simpleFactory_14.sample.pet;

/**
 * Created by oleksandr.baglai on 30.11.2015.
 */
public class PetFactory {

    public static Pet get(String forWhat) {
        if (forWhat.equals("for chess playing")) {
            return new Robot();
        }

        if (forWhat.equals("to protect")) {
            return new Dog();
        }

        if (forWhat.equals("for nothing")) {
            return new Cat();
        }

        if (forWhat.equals("smth scary")) {
            return new Cockroach();
        }

        throw new UnsupportedOperationException("Sorry, no pet for your request: " + forWhat);
    }

}
