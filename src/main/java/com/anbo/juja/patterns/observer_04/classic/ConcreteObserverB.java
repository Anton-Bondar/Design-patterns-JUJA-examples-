package com.anbo.juja.patterns.observer_04.classic;

/**
 * Created by oleksandr.baglai on 03.09.2015.
 */
public class ConcreteObserverB implements Observer {

    @Override
    public void handleEvent(Object input) {
        System.out.println("ConcreteObserverB: " + input + "! Super!");
    }
}
