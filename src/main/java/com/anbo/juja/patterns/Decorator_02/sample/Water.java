package com.anbo.juja.patterns.decorator_02.sample;

/**
 * Created by oleksandr.baglai on 26.08.2015.
 */
public class Water extends Beverage {

    @Override
    public int cost() {
        return 1;
    }

    @Override
    public String description() {
        return "Water";
    }
}
