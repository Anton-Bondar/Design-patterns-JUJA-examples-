package com.anbo.juja.patterns.сhain_of_responsibility_07.classic.case2;

/**
 * Created by oleksandr.baglai on 24.09.2015.
 */
// вот наш ленивый Character-друг из прошлой серии
public class BrokenHandlerD extends Handler {

    @Override
    protected boolean handle(Request request){
        if (request.getMessage() instanceof Character) {
            System.out.printf("Request %s processed by BrokenHandlerD\n", request);
        }
        // теперь-nj он не забудет!
        // клиенту надо вернуть boolean в любом случае (ибо компилятор!),
        // а раз так - он задумается
        // этого старого кода уже не надо
        // else if (successor != null) {
        //     successor.handleRequest(request);
        // }
        return true; // or return false TODO think about it :)
    }
}