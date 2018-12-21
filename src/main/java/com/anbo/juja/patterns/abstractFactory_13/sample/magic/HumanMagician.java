package com.anbo.juja.patterns.abstractFactory_13.sample.magic;

/**
 * Created by oleksandr.baglai on 22.11.2015.
 */
public class HumanMagician implements Magician {
    @Override
    public void wiz() {
        System.out.println("Ученый из расы Людей достал пороховую бомбу и поджег ее");
    }

    @Override
    public void heal(Unit unit) {
        System.out.println("Ученый из расы Людей достал настойку и напоил ею раненого");
    }

    @Override
    public void move() {
        System.out.println("Ученый из расы Людей начал осторожное движение вперед");
    }

    @Override
    public void back() {
        System.out.println("Ученый из расы Людей кинул дымовую бомбу и расворился в дыме");
    }
}
