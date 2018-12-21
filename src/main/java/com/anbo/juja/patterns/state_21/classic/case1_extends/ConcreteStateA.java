package com.anbo.juja.patterns.state_21.classic.case1_extends;

/**
 * Created by oleksandr.baglai on 22.02.2016.
 */
// состояние A
public class ConcreteStateA extends State {

    @Override
    public void handle(Context context, String data) {
        System.out.println("Handled by A: " + data);
        context.setState(new ConcreteStateB());
    }
}
