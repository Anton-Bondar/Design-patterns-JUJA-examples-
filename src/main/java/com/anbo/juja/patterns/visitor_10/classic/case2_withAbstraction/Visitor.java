package com.anbo.juja.patterns.visitor_10.classic.case2_withAbstraction;

/**
 * Created by oleksandr.baglai on 21.10.2015.
 */
// этот интерфейс поднвольный, его определяют те реализации
// Element которые определили в себе метод
//    public void accept(Visitor visitor) {
//        visitor.visit(this);
//    }
public interface Visitor {

    void visit(ConcreteElementA element);

    void visit(ElementB element);

    void visit(ConcreteElementB2 element);
}
