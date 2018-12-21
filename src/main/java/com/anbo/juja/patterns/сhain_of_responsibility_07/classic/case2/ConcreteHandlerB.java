package com.anbo.juja.patterns.сhain_of_responsibility_07.classic.case2;

/**
 * Created by oleksandr.baglai on 24.09.2015.
 */
// этот у нас эксперт по String
public class ConcreteHandlerB extends Handler {

    @Override
    protected boolean handle(Request request){
        boolean canProcess = request.getMessage() instanceof String;
        if (canProcess) {
            System.out.printf("Request %s processed by ConcreteHandlerB\n", request);
        }
        return canProcess;
    }
}