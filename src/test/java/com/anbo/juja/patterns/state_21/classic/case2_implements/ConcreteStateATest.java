package com.anbo.juja.patterns.state_21.classic.case2_implements;

/**
 * Created by oleksandr.baglai on 25.02.2016.
 */
public class ConcreteStateATest extends ConcreteStateTest {

    @Override
    String getPrevName() {
        return "C";
    }

    @Override
    String getName() {
        return "A";
    }

    @Override
    String getNextName() {
        return "B";
    }

    @Override
    Class<? extends State> getPrevStateClass() {
        return ConcreteStateC.class;
    }

    @Override
    State getState(Context context) {
        return new ConcreteStateA(context);
    }

    @Override
    Class<? extends State> getNextStateClass() {
        return ConcreteStateB.class;
    }
}