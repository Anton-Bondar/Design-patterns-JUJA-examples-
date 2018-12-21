package com.anbo.juja.patterns.visitor_10.classic.case2_withAbstraction;

/**
 * Created by oleksandr.baglai on 21.10.2015.
 */
public class ConcreteElementB2Child extends ConcreteElementB2 {

    // наследник ConcreteElementB2
    // сам не хочет ничего делать
    // обработается методом посетителя
    // void visit(ConcreteElementB2 element)
    // как элемент типа ConcreteElementB2
    // поскольку ConcreteElementB2 переопределил
    // void accept(Visitor visitor)

    // тут конечно же какая-то очень полезная логика
    // ...

}
