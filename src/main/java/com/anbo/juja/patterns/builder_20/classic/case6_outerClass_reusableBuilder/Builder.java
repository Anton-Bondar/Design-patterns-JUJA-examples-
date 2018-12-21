package com.anbo.juja.patterns.builder_20.classic.case6_outerClass_reusableBuilder;

/**
 * Created by oleksandr.baglai on 07.02.2016.
 */
// наш билдер (строитель)
// он в каждом своем методе возвращает новый билдек,
// который копирует все из старого
public class Builder {

    // все тех же три поля
    private String field1;
    private String field2;
    private String field3;

    public Builder() {
        // do nothing
    }

    // этот малый называется "копирующий конструктор"
    // на вход принимает инстанс того же экземпляра
    // и все-все копирует
    public Builder(Builder builder) {
        this.field1 = builder.field1;
        this.field2 = builder.field2;
        this.field3 = builder.field3;
    }

    // заметь, каждый метод настройки создает новый билдер
    // и копирует в него допполнительное поле
    // так что this-билдер не меняется, меняется только то,
    // что будет возвращено. Удобно или нет - решать клиенту.
    // Наша задача попробовать разные штуки

    public static Builder field1(String field1) {
        Builder builder = new Builder();
        builder.field1 = field1;
        return builder;
    }

    public Builder field2(String field2) {
        Builder builder = new Builder(this);
        builder.field2 = field2;
        return builder;
    }

    public Builder field3(String field3) {
        Builder builder = new Builder(this);
        builder.field3 = field3;
        return builder;
    }

    // наконец метод конструирования
    public Product build() {
        Product object = new Product(field1, field2);
        object.setField3(field3);
        return object;
    }
}
