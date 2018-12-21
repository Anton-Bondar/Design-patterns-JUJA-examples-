package com.anbo.juja.patterns.nullObject_15.classic.case2_abstractClass;

/**
 * Created by oleksandr.baglai on 09.12.2015.
 */
// пример клиента
public class Client1 {

    private AbstractObject object;

    // который принимает через конструктор объект ставит в поле
    public Client1(AbstractObject object) {
        this.object = object;
    }

    // и позже что-то сделает
    // на стратегию похоже, правда? :)
    public void doSomething(String data) {
        object.request1(data);
        String result2 = object.request2();
        object.request3();
        object.request4(data, result2);
        String result5 = object.request5(data);
        String out = result2 + result5;
        System.out.print(out);
    }
}
