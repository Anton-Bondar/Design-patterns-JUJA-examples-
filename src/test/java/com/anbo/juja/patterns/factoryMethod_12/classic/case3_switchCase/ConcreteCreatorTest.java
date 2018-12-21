package com.anbo.juja.patterns.factoryMethod_12.classic.case3_switchCase;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Created by oleksandr.baglai on 11.11.2015.
 */
public class ConcreteCreatorTest {

    @Test
    public void shouldCreateA() {
        // given
        Creator creator = new ConcreteCreator();

        // when then
        assertEquals(ConcreteProductA.class,
                creator.createProduct("Product A").getClass());
    }

    @Test
    public void shouldCreateB() {
        // given
        Creator creator = new ConcreteCreator();

        // when then
        assertEquals(ConcreteProductB.class,
                creator.createProduct("Product B").getClass());
    }

    @Test
    public void shouldErrorWhenNotExistsProdct() {
        // given
        Creator creator = new ConcreteCreator();

        // when
        try {
            creator.createProduct("Product C");
            fail("Expected exception!");
        } catch (UnsupportedOperationException e) {
            assertEquals("Unexpected product: Product C", e.getMessage());
        }
    }
}
