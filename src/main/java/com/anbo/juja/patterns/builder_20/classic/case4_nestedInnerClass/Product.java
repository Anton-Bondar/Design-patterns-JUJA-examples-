package com.anbo.juja.patterns.builder_20.classic.case4_nestedInnerClass;

/**
 * Created by oleksandr.baglai on 07.02.2016.
 */
// наш продукт
// оу! final class - заявка на immutable
public final class Product {

    // private final поля - точно immutable!
    private final String field1;
    private final String field2;
    private final String field3;

    // инъекция параметров через консструктор
    //
    // конструктор приватный, а значит только билдер
    // может создавать экземпляры product
    private Product(String field1, String field2, String field3) {
        this.field1 = field1;
        this.field2 = field2;
        this.field3 = field3;
    }

    // только get'теры, нет set'теров
    // состояние не меняется - значит immutable!

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

    // для удобства можно сделать такой simple-factory для builder
    // public static Builder builder() {
    //    return new Product.Builder();
    // }

    // билдер, объявленный как nested inner class
    // то есть экземпляр билдера будет как простой outer class
    // только что расоложен внутри Product
    // а значит имеет доступ к его private членам
    public static class Builder {

        // те же самые поля что и Product
        private String field1;
        private String field2;
        private String field3;

        // если в Product будет статический simple-factory builder()
        // то конструктор builder'а можно спрятать вообще
        // private Builder() {
        //    // do nothing
        // }

        // заметь, каждый метод возвращает this
        // чобы можно было делать так
        // builder.field1("data1").field2("data2").field3("data3");

        public Builder field1(String field1) {
            this.field1 = field1;

            return this;
        }

        public Builder field2(String field2) {
            this.field2 = field2;

            return this;
        }

        public Builder field3(String field3) {
            this.field3 = field3;

            return this;
        }

        // ну и наконец метод для возврата готового продукта
        public Product build() {
            return new Product(field1, field2, field3);
        }

    }
}
