package com.anbo.juja.patterns.сhain_of_responsibility_07.classic.case1;

/**
 * Created by oleksandr.baglai on 24.09.2015.
 */
// обработчик специализирующийся на String
public class ConcreteHandlerB extends Handler  {

    @Override
    public void handleRequest(Request request){
        if (request.getMessage() instanceof String) {
            System.out.printf("Request %s processed by ConcreteHandlerB\n", request);
        } else if (successor != null) {
            successor.handleRequest(request);
        }
    }
}