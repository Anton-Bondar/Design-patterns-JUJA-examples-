package com.anbo.juja.patterns.builder_20.classic.case0_classic;

/**
 * Created by oleksandr.baglai on 07.02.2016.
 */
// класс управляющий очередностью эпапов сборки
public class Director {

    // зависит от builder
    private Builder builder;

    // который inject'ится через конструктор (можно и сеттером)
    public Director(Builder builder) {
        this.builder = builder;
    }

    // вот главный метод в котором закодирован план конструирования
    // кстати, если бы он располагался в abstract Builder целиком
    // то это был бы Template Method
    public void construct(){
        builder.buildPart1();
        builder.buildPart2();
        builder.buildPart3();
        builder.buildPart4();
    }

    // метод для получения продукта, делегирующий свое выполнение
    // builder'у. Этот метод будет вызываться клиентом
    public Product getProduct(){
        return builder.getResult();
    }
}
