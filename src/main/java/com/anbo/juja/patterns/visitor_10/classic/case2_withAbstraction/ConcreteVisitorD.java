package com.anbo.juja.patterns.visitor_10.classic.case2_withAbstraction;

/**
 * Created by oleksandr.baglai on 21.10.2015.
 */
// еще один посетитель, который обращается за помощью
// к родителю, чтобы сделать полезное действие
public class ConcreteVisitorD extends AbstractVisitor {

    @Override
    public void visit(ConcreteElementA element) {
        print(4, element);
    }

    @Override
    public void visit(ElementB element) {
        print(5, element);
    }

    @Override
    public void visit(ConcreteElementB2 element) {
        print(6, element);
    }
}
