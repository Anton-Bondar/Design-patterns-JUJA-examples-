package com.anbo.juja.patterns.abstractFactory_13.sample.magic;

/**
 * Created by oleksandr.baglai on 22.11.2015.
 */
public class ElfWarrior implements Warrior {
    @Override
    public void attack() {
        System.out.println("Эльф-воин пошел в рукопашку");
    }

    @Override
    public void move() {
        System.out.println("Эльф-воин начал наступление");
    }

    @Override
    public void back() {
        System.out.println("Эльф-воин залез на дерево и затаился его в кроне");
    }
}
