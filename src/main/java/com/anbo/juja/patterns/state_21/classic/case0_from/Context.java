package com.anbo.juja.patterns.state_21.classic.case0_from;

/**
 * Created by oleksandr.baglai on 22.02.2016.
 */
public class Context {

    private int state;

    public Context() {
        state = 0;
    }

    // этот запрос хочет клиент выполнить
    public void request(String data) {
        if (state == 0) {
            System.out.println("Handled by A: " + data);
            state = 1;
        } else if (state == 1) {
            System.out.println("Handled by B: " + data);
            state = 2;
        } else if (state == 2) {
            System.out.println("Handled by C: " + data);
            state = 0;
        }
    }
}
