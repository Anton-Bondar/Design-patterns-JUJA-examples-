package com.anbo.juja.patterns.сhain_of_responsibility_07.classic.case0;

import ua.com.juja.patterns.chainOfResponsibility.classic.case1.ConcreteHandlerA;
import ua.com.juja.patterns.chainOfResponsibility.classic.case1.ConcreteHandlerB;
import ua.com.juja.patterns.chainOfResponsibility.classic.case1.ConcreteHandlerC;

/**
 * Created by oleksandr.baglai on 24.09.2015.
 */
public class Main {

    public static void main(String[] args) {
        // создали обработчики
        Handler h1 = new Handler(String.class);
        Handler h2 = new Handler(Boolean.class);
        Handler h3 = new Handler(Integer.class);

        // настроили их в очередь
        h1.setSuccessor(h2);
        h2.setSuccessor(h3);

        // пошли обрабатывать
        h1.handleRequest(new Request("qwe"));
        h1.handleRequest(new Request(true));
        h1.handleRequest(new Request(15));

        // Вывод
        // Request String:qwe processed by Handler#1030263813
        // Request Boolean:true processed by Handler#8490467
        // Request Integer:15 processed by Handler#965358167
    }
}
