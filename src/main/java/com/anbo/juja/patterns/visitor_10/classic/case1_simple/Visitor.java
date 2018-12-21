package com.anbo.juja.patterns.visitor_10.classic.case1_simple;

/**
 * Created by oleksandr.baglai on 21.10.2015.
 */
// это наш визитер (или посетитель)
//
// тут могла быть как абстракция в виде abstract class так и в виде interface (как у нас сейчас)
//
// реализация посетителя будет инкапсулировать однотипный алгоритм,
// применимый для всех типов элементов
public interface Visitor {

    // для каждого типа элемента свой метод с логикой
    // всего их столько, сколько у нас есть елементов

    void visit(ConcreteElementA element);

    void visit(ConcreteElementB element);

}
