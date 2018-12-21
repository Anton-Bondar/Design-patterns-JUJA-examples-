package com.anbo.juja.patterns.abstractFactory_13.sample.magic;

/**
 * Created by oleksandr.baglai on 22.11.2015.
 */
public class ElfArcher implements Archer {
    @Override
    public void shoot() {
        System.out.println("Эльф-лучник выстрелил из лука");
    }

    @Override
    public void move() {
        System.out.println("Эльф-лучник обошел врага сбоку");
    }

    @Override
    public void back() {
        System.out.println("Эльф-лучник залез на дерево и продолжает атаку");
    }
}
