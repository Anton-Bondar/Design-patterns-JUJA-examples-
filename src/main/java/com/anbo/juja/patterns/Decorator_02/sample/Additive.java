package com.anbo.juja.patterns.decorator_02.sample;

/**
 * Created by oleksandr.baglai on 26.08.2015.
 */
public abstract class Additive extends Beverage {

    private Beverage beverage;

    public Additive(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public int cost() {
        return beverage.cost();
    }

    @Override
    public String description() {
        return beverage.description() + " + ";
    }
}
