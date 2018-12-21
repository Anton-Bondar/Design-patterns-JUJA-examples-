package com.anbo.juja.patterns.сhain_of_responsibility_07.classic.case2;

/**
 * Created by oleksandr.baglai on 24.09.2015.
 */
// а этот у нас эксперт по Integer
public class ConcreteHandlerC extends Handler {

    @Override
    protected boolean handle(Request request){
        // TODO вот не нравится мне этот дублирующийся везде canProcess
        // есть идеи?
        boolean canProcess = request.getMessage() instanceof Integer;
        if (canProcess) {
            System.out.printf("Request %s processed by ConcreteHandlerC\n", request);
        }
        return canProcess;
    }
}