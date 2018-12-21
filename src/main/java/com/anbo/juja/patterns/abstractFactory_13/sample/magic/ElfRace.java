package com.anbo.juja.patterns.abstractFactory_13.sample.magic;

/**
 * Created by oleksandr.baglai on 22.11.2015.
 */
// фабрика создающая эльфов
public class ElfRace implements Race {
    @Override
    public Magician createMagician() {
        return new ElfMagician();
    }

    @Override
    public Archer createArcher() {
        return new ElfArcher();
    }

    @Override
    public Warrior createWarrior() {
        return new ElfWarrior();
    }
}
