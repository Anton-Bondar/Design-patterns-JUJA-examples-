package com.anbo.juja.patterns.visitor_10.classic.case1_simple;

/**
 * Created by oleksandr.baglai on 21.10.2015.
 */
// а этот посетитель изменяет содержимое элементов
public class ConcreteVisitorD implements Visitor {

    // у него тоже по методу на каждый тип элемента

    @Override
    public void visit(ConcreteElementA element) {
        String data = "newData";
        System.out.printf("%s visited(3) %s, set something %s:%s\n",
                getClass().getSimpleName(),
                element.getClass().getSimpleName(),
                data.getClass().getSimpleName(),
                data);
        element.setSomething(data);
    }

    @Override
    public void visit(ConcreteElementB element) {
        Integer data = 24;
        System.out.printf("%s visited(4) %s, set something %s:%s\n",
                getClass().getSimpleName(),
                element.getClass().getSimpleName(),
                data.getClass().getSimpleName(),
                data);
        element.setSomething(data);
    }
}
