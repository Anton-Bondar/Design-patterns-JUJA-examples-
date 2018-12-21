package com.anbo.juja.patterns.abstractFactory_13.sample.magic;

/**
 * Created by oleksandr.baglai on 22.11.2015.
 */
// юнит-маг
public interface Magician extends Unit {

    // умеет колдовать
    void wiz();

    // умеет лечить
    void heal(Unit unit);

}
