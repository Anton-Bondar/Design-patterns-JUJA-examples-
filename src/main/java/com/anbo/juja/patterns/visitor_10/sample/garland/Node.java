package com.anbo.juja.patterns.visitor_10.sample.garland;

import ua.com.juja.patterns.visitor.sample.garland.element.Changeable;

/**
 * Created by oleksandr.baglai on 22.10.2015.
 */
// тут инкапсулирована логика двусвязного списка
// класс абстрактный и намекает на то,
// что все наследники будут Changeable
public abstract class Node implements Changeable {

    protected Node next;
    protected Node prev;

    // для добавления ноды в конец
    protected <T extends Node> T add(T node) {
        next = node;
        node.prev = this;
        return node;
    }
}
