package com.anbo.juja.patterns.nullObject_15.classic.case1_interfaces;

/**
 * Created by oleksandr.baglai on 09.12.2015.
 */
// null-объект который ничего не будет делать
public class NullObject implements Abstraction {

    @Override
    public void request(String input) {
        // do nothing
        // то есть абсолютно ничего!
    }
}
