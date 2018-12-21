package com.anbo.juja.patterns.decorator_02.sample;

/**
 * Created by oleksandr.baglai on 26.08.2015.
 */
public abstract class Beverage {

    public abstract int cost();

    public abstract String description();

    @Override
    public String toString() {
        return String.format("%s = %s$", description(), cost());
    }

}
