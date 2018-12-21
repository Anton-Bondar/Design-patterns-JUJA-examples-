package com.anbo.juja.patterns.simpleFactory_14.sample.pet;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by oleksandr.baglai on 30.11.2015.
 */
public class PetsTest {

    @Test
    public void shouldDogVoice() {
        // given
        Pet pet = new Dog();

        // when
        String voice = pet.voice();

        // then
        assertEquals("OUUF!", voice);
    }

    @Test
    public void shouldCatVoice() {
        // given
        Pet pet = new Cat();

        // when
        String voice = pet.voice();

        // then
        assertEquals("Meow...", voice);
    }

    @Test
    public void shouldRobotVoice() {
        // given
        Pet pet = new Robot();

        // when
        String voice = pet.voice();

        // then
        assertEquals("1001001001010011", voice);
    }

    @Test
    public void shouldCockroachVoice() {
        // given
        Pet pet = new Cockroach();

        // when
        String voice = pet.voice();

        // then
        assertEquals("...", voice);
    }
}
