package com.anbo.juja.patterns.nullObject_15.classic.case2_abstractClass;

/**
 * Created by oleksandr.baglai on 09.12.2015.
 */
// пример клиента
public class Client2 {

    private String data = "data";

    // который на вход принимает объект
    // и с ним деалает что-то сразу
    public void doSomething(AbstractObject object) {
        object.request1(data);
        String result2 = object.request2();
        object.request3();
        object.request4(data, result2);
        String result5 = object.request5(data);
        System.out.print(result2 + result5);
    }
}
