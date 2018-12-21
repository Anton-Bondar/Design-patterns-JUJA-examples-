package com.anbo.juja.patterns.factoryMethod_12.classic.case2_abstractClass;

/**
 * Created by oleksandr.baglai on 11.11.2015.
 */
// класс-запускатор
public class Main {

    public static void main(String[] args) {
        // где-то в системе (не на стороне клиента) создается фектори
        Creator creator = new ConcreteCreatorA();
        // Creator creator = new ConcreteCreatorB();

        // наш клиент
        Client client = new Client();

        // обрабатывает данные и получает на вход creator
        String result = client.process("data", "config", creator);

        System.out.println(result);
        // Вывод:
        // ConcreteProductA[config]: data
        // или
        // ConcreteProductB[config]: data
    }


}
