package com.anbo.juja.patterns.visitor_10.classic.case1_simple;

/**
 * Created by oleksandr.baglai on 21.10.2015.
 */
// это наша абстракиця элемента
// любая его реализация обязана определить в реализации одну единственную строчку
// visitor.visit(this);
// тут без дублирования никак, если мы вынесем ее в асбтрактный для всех елементов класс
// то фокуса не получится. Уточнение типа элемента случается как раз в коде объекта, но не родителя
public interface Element {

    void accept(Visitor visitor);

}
