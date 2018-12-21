package com.anbo.juja.patterns.immutable_16.hashMapError;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Created by oleksandr.baglai on 21.12.2015.
 */
public class HashMapTest {

    @Test
    public void test() {
        // given
        Map<Key, Object> map = new HashMap<>();

        Key key1 = new Key("key1");
        Key key2 = new Key("key2");

        map.put(key1, "object1");
        map.put(key2, "object2");

        // then
        assertEquals("object1", map.get(key1));
        assertEquals("object1", map.get(new Key("key1")));

        assertEquals("object2", map.get(key2));
        assertEquals("object2", map.get(new Key("key2")));

        // when
        key1.setData("key1_changed");

        // then
        assertEquals(null, map.get(key1));
        assertEquals("object2", map.get(key2));

        assertEquals(2, map.size());

        assertEquals(null, map.get(new Key("key1")));
        assertEquals(null, map.get(new Key("key1_changed")));

        assertEquals("{key2=object2, key1_changed=object1}",
                map.toString());
    }
}
