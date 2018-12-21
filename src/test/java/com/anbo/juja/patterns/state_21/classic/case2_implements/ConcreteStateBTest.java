package com.anbo.juja.patterns.state_21.classic.case2_implements;

/**
 * Created by oleksandr.baglai on 25.02.2016.
 */
public class ConcreteStateBTest extends ConcreteStateTest {

    @Override
    String getPrevName() {
        return "A";
    }

    @Override
    String getName() {
        return "B";
    }

    @Override
    String getNextName() {
        return "C";
    }

    @Override
    Class<? extends State> getPrevStateClass() {
        return ConcreteStateA.class;
    }

    @Override
    State getState(Context context) {
        return new ConcreteStateB(context);
    }

    @Override
    Class<? extends State> getNextStateClass() {
        return ConcreteStateC.class;
    }
}