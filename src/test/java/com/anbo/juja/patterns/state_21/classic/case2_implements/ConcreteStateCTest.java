package com.anbo.juja.patterns.state_21.classic.case2_implements;

/**
 * Created by oleksandr.baglai on 25.02.2016.
 */
public class ConcreteStateCTest extends ConcreteStateTest {

    @Override
    String getPrevName() {
        return "B";
    }

    @Override
    String getName() {
        return "C";
    }

    @Override
    String getNextName() {
        return "A";
    }

    @Override
    Class<? extends State> getPrevStateClass() {
        return ConcreteStateB.class;
    }

    @Override
    State getState(Context context) {
        return new ConcreteStateC(context);
    }

    @Override
    Class<? extends State> getNextStateClass() {
        return ConcreteStateA.class;
    }
}