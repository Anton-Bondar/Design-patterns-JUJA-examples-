package com.anbo.juja.patterns.abstractFactory_13.sample.magic;

/**
 * Created by oleksandr.baglai on 22.11.2015.
 */
// абстрактная фабрика
// (тут под видом интерфейса)
public interface Race {

    // создаем мага
    Magician createMagician();

    // создаем стрелка
    Archer createArcher();

    // создаем воина
    Warrior createWarrior();
}
