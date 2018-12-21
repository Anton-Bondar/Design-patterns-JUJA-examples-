package com.anbo.juja.patterns.сhain_of_responsibility_07.classic.case2;

/**
 * Created by oleksandr.baglai on 24.09.2015.
 */
public class Main {

    // тут без изменений
    public static void main(String[] args) {
        // создали обработчики
        Handler h1 = new ConcreteHandlerA();
        Handler h2 = new ConcreteHandlerB();
        Handler h3 = new ConcreteHandlerC();

        // настроили их в очередь
        h1.setSuccessor(h2);
        h2.setSuccessor(h3);

        // пошли обрабатывать
        h1.handleRequest(new Request("qwe"));
        h1.handleRequest(new Request(true));
        h1.handleRequest(new Request(15));

        // Вывод
        // Request String:qwe processed by ConcreteHandlerB
        // Request Boolean:true processed by ConcreteHandlerA
        // Request Integer:15 processed by ConcreteHandlerC
    }
}