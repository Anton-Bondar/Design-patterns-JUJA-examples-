package com.anbo.juja.patterns.simpleFactory_14.sample.pet;

/**
 * Created by oleksandr.baglai on 30.11.2015.
 */
public class Main {

    public static void main(String[] args) {
        // завели тварбчек в магазине
        Pet bibip = PetFactory.get("for chess playing");
        Pet grack = PetFactory.get("to protect");
        Pet mimi = PetFactory.get("for nothing");
        Pet copyPast = PetFactory.get("smth scary");

        // принесли домой и ...
        System.out.println(bibip.voice());
        System.out.println(grack.voice());
        System.out.println(mimi.voice());
        System.out.println(copyPast.voice());

        // вывод:
        // 1001001001010011
        // OUUF!
        // Meow...
        // ...
    }
}
