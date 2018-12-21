package com.anbo.juja.patterns.decorator_02.sample;

/**
 * Created by oleksandr.baglai on 26.08.2015.
 */
public class Salt extends Additive {

    public Salt(Beverage beverage) {
        super(beverage);
    }

    @Override
    public int cost() {
        return super.cost() + 1;
    }

    @Override
    public String description() {
        return super.description() + "Salt";
    }
}
