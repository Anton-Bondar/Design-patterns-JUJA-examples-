package com.anbo.juja.patterns.builder_20.classic.case3_memberInnerClass;

/**
 * Created by oleksandr.baglai on 07.02.2016.
 */
// наш продукт
public class Product {

    // тут нельзя сделать final, а значит никакого
    // immutable не получится
    private String field1;
    private String field2;
    private String field3;

    // private конструктор, чтобы никто без билдера не смог создать продукт
    private Product() {
        // do nothing
    }

    // get'теры

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

    // статический метод для удобства получения билдера
    // заметь Product.builder()... красивее чем
    // new Product().new Builder()...
    // тем более, то конструкторы private,
    // иначе клиент будет создавать кродукты без builder "мимо кассы"
    public static Builder builder() {
        return new Product().new Builder();
    }

    // билдер, объявленный как member inner class
    // то есть экземпляр билдера будет привязан к конкретному объекту
    public class Builder {

        // private конструктор, чтобы никто не мог кроме статического
        // метода Product.build() создавать билдеры
        private Builder() {
            // do nothing
        }

        // вроде как безобидный метод для установки поля,
        // но если сохранить ссылочку на builder, то
        // потом (после конструирования) можно нарушать
        // инкапсуляцию объекта Product ;)
        public Builder field1(String field1) {
            Product.this.field1 = field1;

            return this;
        }

        // так как это inner member class то можно set'ать поля объекта
        // от которого зависим напрямую через Product.this.
        public Builder field2(String field2) {
            Product.this.field2 = field2;

            return this;
        }

        // заметь каждый метод возвращает this
        // чобы можно было делать так
        // builder.field1("data1").field2("data2").field3("data3");
        public Builder field3(String field3) {
            Product.this.field3 = field3;

            return this;
        }

        // ну и метод возвращающий реультат
        public Product build() {
            return Product.this;
        }

    }
}
