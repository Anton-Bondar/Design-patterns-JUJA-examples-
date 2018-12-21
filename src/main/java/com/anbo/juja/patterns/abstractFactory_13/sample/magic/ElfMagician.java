package com.anbo.juja.patterns.abstractFactory_13.sample.magic;

/**
 * Created by oleksandr.baglai on 22.11.2015.
 */
public class ElfMagician implements Magician {
    @Override
    public void wiz() {
        System.out.println("Эльф-маг вызвал заклинание и подгнялся сильный ураган");
    }

    @Override
    public void heal(Unit unit) {
        System.out.println("Эльф-маг достал волшебное растение и вылечил воина");
    }

    @Override
    public void move() {
        System.out.println("Эльф-маг начал движение");
    }

    @Override
    public void back() {
        System.out.println("Эльф-маг вызвал заклинание и исчез");
    }
}
