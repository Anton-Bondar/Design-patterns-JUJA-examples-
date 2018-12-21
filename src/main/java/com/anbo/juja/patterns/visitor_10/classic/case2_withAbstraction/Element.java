package com.anbo.juja.patterns.visitor_10.classic.case2_withAbstraction;

/**
 * Created by oleksandr.baglai on 21.10.2015.
 */
// тут все без изменений - интерфейс константа!
public interface Element {

    void accept(Visitor visitor);

}
