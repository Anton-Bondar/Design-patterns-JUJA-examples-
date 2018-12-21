package com.anbo.juja.patterns.builder_20.classic.case1_doubleBraceInitialization;

/**
 * Created by oleksandr.baglai on 07.02.2016.
 */
// наш продукт который мы собираем
// почти pojo бин - ничего сложного
// поля protected - чтобы можно было в наследниках их пере'set'ать
// а set'теров нет - только get'теры
public class Product {

    protected String field1;
    protected String field2;
    protected String field3;

    public String getField1() {
        return field1;
    }

    public String getField2() {
        return field2;
    }

    public String getField3() {
        return field3;
    }

    @Override
    public String toString() {
        return String.format("SomeObject{field1='%s\', " +
                "field2='%s\', field3='%s\'}",
                field1, field2, field3);
    }
}
