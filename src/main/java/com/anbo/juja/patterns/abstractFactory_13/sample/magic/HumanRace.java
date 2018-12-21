package com.anbo.juja.patterns.abstractFactory_13.sample.magic;

/**
 * Created by oleksandr.baglai on 22.11.2015.
 */
// фабрика создающая людей
public class HumanRace implements Race {
    @Override
    public Magician createMagician() {
        return new HumanMagician();
    }

    @Override
    public Archer createArcher() {
        return new HumanArcher();
    }

    @Override
    public Warrior createWarrior() {
        return new HumanWarrior();
    }
}
