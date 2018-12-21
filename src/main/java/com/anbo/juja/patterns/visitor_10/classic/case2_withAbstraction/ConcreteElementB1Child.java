package com.anbo.juja.patterns.visitor_10.classic.case2_withAbstraction;

/**
 * Created by oleksandr.baglai on 21.10.2015.
 */
public class ConcreteElementB1Child extends ConcreteElementB1 {

    // наследник ConcreteElementB1
    // сам не хочет ничего делать
    // обработается методом посетителя
    // void visit(ElementB element)
    // как элемент типа ElementB,
    // потому что ConcreteElementB1 тоже не реализовал
    // void accept(Visitor visitor)

    // тут конечно же какая-то очень полезная логика
    // ...

}
