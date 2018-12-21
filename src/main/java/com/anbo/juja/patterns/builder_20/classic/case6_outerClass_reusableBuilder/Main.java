package com.anbo.juja.patterns.builder_20.classic.case6_outerClass_reusableBuilder;

/**
 * Created by oleksandr.baglai on 07.02.2016.
 */
// класс-запускатор
public class Main {

    public static void main(String[] args) {
        // тут все так же как и в прошлом примере за исключением того,
        // что билдер можно повторно использовать для создания группы объектов
        // со сходными свойствами

        // тут пример для одного объекта
        Product object1 =
                Builder.field1("data1")
                        .field2("data2")
                        .field3("data3")
                        .build();

        System.out.println(object1);
        // SomeObject{field1='data1', field2='data2', field3='data3'}

        // а вот тут для нескольких
        Builder builder =
                Builder.field1("data1")
                        .field2("data2")
                        .field3("data3");
        Product object2 = builder.build();
        Product object3 = builder.field2("changed2").build();
        Product object4 = builder.field3("changed3").build();

        System.out.println(object2);
        // SomeObject{field1='data1', field2='data2', field3='data3'}
        System.out.println(object3);
        // SomeObject{field1='data1', field2='changed2', field3='data3'}
        System.out.println(object4);
        // SomeObject{field1='data1', field2='data2', field3='changed3'}
    }
}
