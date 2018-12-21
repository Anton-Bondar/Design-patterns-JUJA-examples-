package com.anbo.juja.patterns.decorator_02.sample;

/**
 * Created by oleksandr.baglai on 26.08.2015.
 */
public class Sugar extends Additive {

    public Sugar(Beverage beverage) {
        super(beverage);
    }

    @Override
    public int cost() {
        return super.cost() + 2;
    }

    @Override
    public String description() {
        return super.description() + "Sugar";
    }
}
