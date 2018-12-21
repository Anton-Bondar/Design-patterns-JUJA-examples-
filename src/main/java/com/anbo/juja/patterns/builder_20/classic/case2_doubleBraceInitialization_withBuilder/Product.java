package com.anbo.juja.patterns.builder_20.classic.case2_doubleBraceInitialization_withBuilder;

/**
 * Created by oleksandr.baglai on 07.02.2016.
 */
// наш продукт который мы собираем
// его специально сделал immutable, чтобы показать что это возможно
// класс - final
public final class Product {

    // поля private final
    private final String field1;
    private final String field2;
    private final String field3;

    // все инитим через конструктор, set'теров нет
    // конструктор кстати private - чтобы никто извне
    // его не вызвал, кроме как через Builder
    private Product(String field1, String field2, String field3) {
        this.field1 = field1;
        this.field2 = field2;
        this.field3 = field3;
    }

    // только get'теры
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

    // но есть nested inner class билдер
    public static class Builder {
        // который содержит ровно столько же полей
        // поля protected чтобы переопределить их в анонимном наследнике
        protected String field1  = "default1";
        protected String field2  = "default2";
        protected String field3  = "default3";

        // и метод build
        public Product build() {
            // в котором может быть валидация

            // и происходит вызов конструктора продукта
            return new Product(
                    field1,
                    field2,
                    field3
            );
        }
    }

}
