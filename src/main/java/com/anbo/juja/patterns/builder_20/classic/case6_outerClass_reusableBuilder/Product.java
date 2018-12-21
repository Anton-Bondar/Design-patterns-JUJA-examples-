package com.anbo.juja.patterns.builder_20.classic.case6_outerClass_reusableBuilder;

/**
 * Created by oleksandr.baglai on 07.02.2016.
 */
// наш продукт. Банальный pojo - два поля set'аются через конструктор
// одно через set'тер
public class Product {

    private String field1;
    private String field2;
    private String field3;

    public Product(String field1, String field2) {
        this.field1 = field1;
        this.field2 = field2;
    }

    public void setField3(String field3) {
        this.field3 = field3;
    }

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
