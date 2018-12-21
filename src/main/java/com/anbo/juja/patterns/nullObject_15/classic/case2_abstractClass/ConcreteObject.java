package com.anbo.juja.patterns.nullObject_15.classic.case2_abstractClass;

/**
 * Created by oleksandr.baglai on 09.12.2015.
 */
// это какой-то реальный объект, делающий полезную логику
public class ConcreteObject extends AbstractObject {

    @Override
    public void request1(String input) {
        System.out.printf("request1('%s')\n", input);
    }

    @Override
    public String request2() {
        String result = "result2";
        System.out.printf("request2() = %s\n", result);
        return result;
    }

    @Override
    public void request3() {
        System.out.printf("request3()\n");
    }

    @Override
    public void request4(String input1, String input2) {
        System.out.printf("request4('%s', '%s')\n", input1, input2);
    }
}
