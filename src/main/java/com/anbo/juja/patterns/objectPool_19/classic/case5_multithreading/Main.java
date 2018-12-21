package com.anbo.juja.patterns.objectPool_19.classic.case5_multithreading;

/**
 * Created by oleksandr.baglai on 28.01.2016.
 */
// класс-запускатор
public class Main {

    public static void main(String[] args) {
        // создаем пул ресурсов, в котором будет не больше 3х элементов
        ObjectPool pool = new ObjectPool(3);

        // конфигурируем клиента пулом ресурсов
        Client client = new Client(pool);

        // выполняем полезную логику для которой потребуется больше ресурсов
        client.doSomething(6);
    }
}
