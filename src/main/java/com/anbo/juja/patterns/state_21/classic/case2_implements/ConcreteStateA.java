package com.anbo.juja.patterns.state_21.classic.case2_implements;

/**
 * Created by oleksandr.baglai on 22.02.2016.
 */
// состояние A
public class ConcreteStateA implements State {

    private Context context;

    public ConcreteStateA(Context context) {
        this.context = context;
    }

    @Override
    public void handle1(String data) {
        System.out.println("Handled by A: " + data);
        context.setState(context.STATE_B);
    }

    @Override
    public String handle2() {
        context.setState(context.STATE_C);
        return "Handled by A";
    }
}
