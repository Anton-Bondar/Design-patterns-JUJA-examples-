package com.anbo.juja.patterns.observer_04.classic;

/**
 * Created by oleksandr.baglai on 03.09.2015.
 */
public class Main {

    public static void main(String[] args) {
        Observable observable = new ConcreteObservable();

        Observer observer1 = new ConcreteObserverA();
        observable.addObserver(observer1);

        Observer observer2 = new ConcreteObserverA();
        observable.addObserver(observer2);

        Observer observer3 = new ConcreteObserverB();
        observable.addObserver(observer3);

        observable.notifyObservers("Hello Observer");

        observable.removeObserver(observer3);

        observable.notifyObservers("Hello Again");
    }
}
