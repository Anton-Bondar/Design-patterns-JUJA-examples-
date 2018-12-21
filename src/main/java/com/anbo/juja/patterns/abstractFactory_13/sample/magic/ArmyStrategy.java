package com.anbo.juja.patterns.abstractFactory_13.sample.magic;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Created by oleksandr.baglai on 22.11.2015.
 */
public class ArmyStrategy {

    public List<Unit> makeSquad(Race factory) {
        List<Unit> squad = new LinkedList<>();

        squad.add(factory.createArcher());
        squad.add(factory.createMagician());
        squad.add(factory.createWarrior());

        return squad;
    }

    public void attack(List<Unit> squad) {
        for (Unit unit : squad) {
            unit.move();
        }

        for (Unit unit : squad) {
            if (unit instanceof Archer) {
                ((Archer) unit).shoot();
            }
        }

        for (Unit unit : squad) {
            if (unit instanceof Warrior) {
                ((Warrior) unit).attack();
            }
        }

        for (Unit unit : squad) {
            if (unit instanceof Magician) {
                Unit wounded = squad.get(new Random().nextInt(squad.size()));
                ((Magician) unit).heal(wounded);
            }
        }

        for (Unit unit : squad) {
            unit.back();
        }
    }
}
