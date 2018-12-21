package com.anbo.juja.patterns.сhain_of_responsibility_07.classic.case1;

/**
 * Created by oleksandr.baglai on 24.09.2015.
 */
// обработчик специализирующийся на Character
// но он не простой...
public class BrokenHandlerD extends Handler  {

    @Override
    public void handleRequest(Request request){
        if (request.getMessage() instanceof Character) {
            System.out.printf("Request %s processed by BrokenHandlerD\n", request);
        }
        // Он забыл позаботиться о передаче сигнала
        // и потому все, что выстроились дальше не получат его
        // else if (successor != null) {
        //     successor.handleRequest(request);
        // }
        // TODO надо с этим что-то сделать!
        // есть идеи?
    }
}