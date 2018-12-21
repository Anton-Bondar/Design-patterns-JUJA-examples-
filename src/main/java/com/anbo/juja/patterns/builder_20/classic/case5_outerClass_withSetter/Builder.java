package com.anbo.juja.patterns.builder_20.classic.case5_outerClass_withSetter;

/**
 * Created by oleksandr.baglai on 07.02.2016.
 */
public class Builder {

    private String field1;
    private String field2;
    private String field3;

    public Builder(String field1) {
        this.field1 = field1;
    }

    public static Builder field1(String field1) {
        return new Builder(field1);
    }

    public Builder field2(String field2) {
        this.field2 = field2;
        return this;
    }

    public Builder field3(String field3) {
        this.field3 = field3;
        return this;
    }

    public Product build() {
        validateMandatory(field1, field2);

        Product object = new Product(field1, field2);
        object.setField3(field3);
        return object;
    }

    private void validateMandatory(String field1, String field2) {
        if (field1 == null) {
            throw new IllegalArgumentException("Вы забыли установить field1");
        }
        if (field2 == null) {
            throw new IllegalArgumentException("Вы забыли установить field2");
        }
    }
}
