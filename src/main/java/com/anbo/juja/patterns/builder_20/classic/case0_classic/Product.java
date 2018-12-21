package com.anbo.juja.patterns.builder_20.classic.case0_classic;

/**
 * Created by oleksandr.baglai on 07.02.2016.
 */
// наш продукт который мы собираем
// pojo бин - ничего сложного. Private поля, get'теры и set'теры...
public class Product {

    private String field1;
    private String field2;
    private String field3;

    public String getField1() {
        return field1;
    }

    public String getField2() {
        return field2;
    }

    public String getField3() {
        return field3;
    }

    public void setField1(String field1) {
        this.field1 = field1;
    }

    public void setField2(String field2) {
        this.field2 = field2;
    }

    public void setField3(String field3) {
        this.field3 = field3;
    }

    @Override
    public String toString() {
        return String.format("SomeObject{field1='%s\', " +
                "field2='%s\', field3='%s\'}",
                field1, field2, field3);
    }
}
