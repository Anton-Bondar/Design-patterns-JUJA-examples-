package com.anbo.juja.patterns.decorator_02.sample;

/**
 * Created by oleksandr.baglai on 26.08.2015.
 */
public class CoolSugar extends Additive {

    private int count;

    public CoolSugar(Beverage beverage, int count) {
        super(beverage);
        this.count = count;
    }

    @Override
    public int cost() {
        return super.cost() + 2*count;
    }

    @Override
    public String description() {
        return super.description() + count + " x Sugar";
    }
}
