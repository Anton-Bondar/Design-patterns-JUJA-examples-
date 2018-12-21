package com.anbo.juja.patterns.builder_20.classic.case0_classic;

/**
 * Created by oleksandr.baglai on 07.02.2016.
 */
// часть строителя, которая отвечает на вопрос, как происходят
// этапы конструирования
public class ConcreteBuilder extends Builder {

    @Override
    public void buildPart2() {
        // тут на самом деле логика может быть и по-сложнее
        // ну а демо целях - и это пойдет
        product.setField1("data1");
    }

    @Override
    public void buildPart3() {
        product.setField2("data2");
    }

    @Override
    public void buildPart4() {
        product.setField3("data3");
    }
}
