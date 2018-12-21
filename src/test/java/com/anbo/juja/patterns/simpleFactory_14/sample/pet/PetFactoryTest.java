package com.anbo.juja.patterns.simpleFactory_14.sample.pet;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by oleksandr.baglai on 30.11.2015.
 */
public class PetFactoryTest {

    @Test
    public void shouldGetDog() {
        // given
        Pet pet = PetFactory.get("to protect");

        // when then
        assertEquals(Dog.class, pet.getClass());
    }

    @Test
    public void shouldGetCat() {
        // given
        Pet pet = PetFactory.get("for nothing");

        // when then
        assertEquals(Cat.class, pet.getClass());
    }

    @Test
    public void shouldGetCockroach() {
        // given
        Pet pet = PetFactory.get("smth scary");

        // when then
        assertEquals(Cockroach.class, pet.getClass());
    }

    @Test
    public void shouldGetRobot() {
        // given
        Pet pet = PetFactory.get("for chess playing");

        // when then
        assertEquals(Robot.class, pet.getClass());
    }
}
