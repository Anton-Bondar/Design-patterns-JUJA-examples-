package com.anbo.juja.patterns.abstractFactory_13.sample.magic;

/**
 * Created by oleksandr.baglai on 22.11.2015.
 */
public class HumanWarrior implements Warrior {
    @Override
    public void attack() {
        System.out.println("Воин из расы Людей достал меч и пошел в атаку");
    }

    @Override
    public void move() {
        System.out.println("Воин из расы Людей с криком пошел в наступление");
    }

    @Override
    public void back() {
        System.out.println("Воин из расы Людей спасается бегством");
    }
}
