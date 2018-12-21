package com.anbo.juja.patterns.visitor_10.sample.garland;

import org.junit.Test;
import ua.com.juja.patterns.visitor.sample.garland.music.Music;

import static org.junit.Assert.assertSame;

/**
 * Created by oleksandr.baglai on 23.10.2015.
 */
public class NodeTest {

    private static class NewNode extends Node {
        @Override
        public void change(Music music) {
            // do nothing
        }
    }

    @Test
    public void testAdd() {
        // given
        Node node1 = new NewNode();
        Node node2 = new NewNode();
        Node node3 = new NewNode();
        Node node4 = new NewNode();

        // when
        node1.add(node2).add(node3).add(node4);

        // then
        assertSame(null,  node1.prev);
        assertSame(node2, node1.next);

        assertSame(node1, node2.prev);
        assertSame(node3, node2.next);

        assertSame(node2, node3.prev);
        assertSame(node4, node3.next);

        assertSame(node3, node4.prev);
        assertSame(null,  node4.next);
    }
}
