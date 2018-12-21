package com.anbo.juja.patterns.bridge_22.classic;

/**
 * Created by oleksandr.baglai on 25.02.2016.
 */
// Класс - запускатор
public class Main {

    public static void main(String[] args) {
        // выбираем имплементацию абстракции
        Implementor implementor = new ConcreteImplementorA();
//        Implementor implementor = new ConcreteImplementorB(new SpeechUtils());

        // уточняем абстракцию (их кстати может быть тоже несколько разных)
        Abstraction abstraction = new RefinedAbstractionC(implementor);
//        Abstraction abstraction = new RefinedAbstractionD(implementor);

        // полезная нагрузка
        abstraction.operation("hello world");
        abstraction.operation('!');
        abstraction.operation(37);
        abstraction.operation(true);
    }
}
