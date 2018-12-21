package com.anbo.juja.patterns.abstractFactory_13.sample.magic;

/**
 * Created by oleksandr.baglai on 22.11.2015.
 */
public class HumanArcher implements Archer {
    @Override
    public void shoot() {
        System.out.println("Арбалетчик из расы Людей достал арбалет и выстрелил");
    }

    @Override
    public void move() {
        System.out.println("Арбалетчик из расы Людей начал наступление");
    }

    @Override
    public void back() {
        System.out.println("Арбалетчик из расы Людей отступает отстреливаясь");
    }
}
