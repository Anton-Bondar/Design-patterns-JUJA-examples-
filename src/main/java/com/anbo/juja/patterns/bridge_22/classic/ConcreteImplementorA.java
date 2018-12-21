package com.anbo.juja.patterns.bridge_22.classic;

/**
 * Created by oleksandr.baglai on 25.02.2016.
 */
// содержит конкретную реализацию интерфейса класса Implementor
public class ConcreteImplementorA extends Implementor {

    @Override
    public void operationImpl(char data) {
        System.out.print(data);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
