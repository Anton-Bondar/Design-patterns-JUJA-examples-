package com.anbo.juja.patterns.сhain_of_responsibility_07.classic.case1;

/**
 * Created by oleksandr.baglai on 24.09.2015.
 */
// обработчик специализирующийся на Integer
public class ConcreteHandlerC extends Handler  {

    @Override
    public void handleRequest(Request request){
        if (request.getMessage() instanceof Integer) {
            System.out.printf("Request %s processed by ConcreteHandlerC\n", request);
        } else if (successor != null) {
            successor.handleRequest(request);
        }
    }
}