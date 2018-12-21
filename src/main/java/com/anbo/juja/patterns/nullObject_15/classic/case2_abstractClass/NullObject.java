package com.anbo.juja.patterns.nullObject_15.classic.case2_abstractClass;

/**
 * Created by oleksandr.baglai on 09.12.2015.
 */
// null-объект который ничего не будет делать
public class NullObject extends AbstractObject {

    @Override
    public void request1(String input) {
        // do nothing
    }

    @Override
    public String request2() {
        // тут надо вернуть что-то безопасное
        return ""; // потому что дальше по цепочке может быть NPE
    }

    @Override
    public void request3() {
        // do nothing
    }

    @Override
    public void request4(String input1, String input2) {
        // do nothing
    }

    // метод мы переопределили так, чтобы клиенту показалось что все ок
    // но в результате ничего не произошло
    @Override
    public String request5(String input) {
        return ""; // что-то чтобы не случился NPE
    }
}
