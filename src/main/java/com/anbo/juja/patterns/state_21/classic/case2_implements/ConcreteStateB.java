package com.anbo.juja.patterns.state_21.classic.case2_implements;

/**
 * Created by oleksandr.baglai on 22.02.2016.
 */
// состояние B
public class ConcreteStateB implements State {

    private Context context;

    public ConcreteStateB(Context context) {
        this.context = context;
    }

    @Override
    public void handle1(String data) {
        System.out.println("Handled by B: " + data);
        context.setState(context.STATE_C);
    }

    @Override
    public String handle2() {
        context.setState(context.STATE_A);
        return "Handled by B";
    }
}
