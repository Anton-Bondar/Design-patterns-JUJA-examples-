package com.anbo.juja.patterns.abstractFactory_13.classic;

/**
 * Created by oleksandr.baglai on 22.11.2015.
 */
// класс-запускатор
public class Main {

    public static void main(String[] args) {
        // где-то в системе (не на стороне клиента) создается фектори
        AbstractFactory factory = new ConcreteFactoryA();
        // AbstractFactory factory = new ConcreteFactoryB();

        // наш клиент
        Client client = new Client();

        // обрабатывает данные и получает на вход factory
        Product2 result = client.process(factory);

        System.out.println(result);
        // Вывод:
        // printedA: changedA: oneA-changedA: anotherA
        // или
        // printedB: changedB: oneB-changedB: anotherB
    }


}
