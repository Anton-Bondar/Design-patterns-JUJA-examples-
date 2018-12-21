package com.anbo.juja.patterns.immutable_16.classic;

import org.junit.Test;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by oleksandr.baglai on 21.12.2015.
 */
public class MutableTest {

    @Test
    public void testConstructorBefore() {
        // given
        List<String> list = new LinkedList<>();
        list.add("fail");

        // when
        Mutable mutable = new Mutable(list);

        // then
        assertEquals("[fail]", mutable.toString());
    }

    @Test
    public void caseConstructorAfter() {
        // given
        List<String> list = new LinkedList<>();

        Mutable mutable = new Mutable(list);

        // when
        list.add("fail");

        // then
        assertEquals("[fail]", mutable.toString());
    }

    static class NewMutable extends Mutable {

        public NewMutable(List<String> data) {
            super(data);
        }

        public void add(String string) {
            data.add(string);
        }
    }

    @Test
    public void caseSubclass() {
        // given
        List<String> list = new LinkedList<>();

        NewMutable mutable = new NewMutable(list);

        // when
        mutable.add("fail");

        // then
        assertEquals("[fail]", mutable.toString());
    }

    @Test
    public void caseAnonymousSubclass() {
        // given
        List<String> list = new LinkedList<>();

        Mutable mutable = new Mutable(list) {
            // when
            {
                data.add("fail");
            }
        };

        // then
        assertEquals("[fail]", mutable.toString());
    }

    @Test
    public void caseSetterBefore() {
        // given
        List<String> list = new LinkedList<>();
        Mutable mutable = new Mutable(list);

        // when
        List<String> newList = new LinkedList<>();
        newList.add("fail");
        mutable.setData(newList);

        // then
        assertEquals("[fail]", mutable.toString());
    }

    @Test
    public void caseSetterAfter() {
        // given
        List<String> list = new LinkedList<>();
        Mutable mutable = new Mutable(list);

        List<String> newList = new LinkedList<>();
        mutable.setData(newList);

        // when
        newList.add("fail");

        // then
        assertEquals("[fail]", mutable.toString());
    }

    @Test
    public void caseGetter() {
        // given
        List<String> list = new LinkedList<>();

        Mutable mutable = new Mutable(list);

        // when
        mutable.getData().add("fail");

        // then
        assertEquals("[fail]", mutable.toString());
    }

    @Test
    public void caseReflection() throws Exception {
        // given
        List<String> list = new LinkedList<>();

        Mutable mutable = new Mutable(list);

        // when
        Field data = mutable.getClass().getDeclaredField("data");
        data.setAccessible(true);
        data.set(mutable, Arrays.asList("fail"));
        data.setAccessible(false);

        // then
        assertEquals("[fail]", mutable.toString());
    }
}
