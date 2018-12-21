package com.anbo.juja.patterns.state_21.classic.case1_extends;

/**
 * Created by oleksandr.baglai on 22.02.2016.
 */
// состояние C
public class ConcreteStateC extends State {

    @Override
    public void handle(Context context, String data) {
        System.out.println("Handled by C: " + data);
        context.setState(new ConcreteStateA());
    }
}
