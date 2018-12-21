package com.anbo.juja.patterns.сhain_of_responsibility_07.classic.case3;

/**
 * Created by oleksandr.baglai on 24.09.2015.
 */
public class ConcreteHandlerA extends Handler {

    // теперь каждый хендлер туп

    // его вначале дернут за этот метод
    // дабы узнать, созрел ли он для подобного запроса
    @Override
    protected boolean canHandle(Request request) {
        return request.getMessage() instanceof Boolean;
    }

    // и если созрел - дернут за этот
    @Override
    protected void handle(Request request){
        System.out.printf("Request %s processed by ConcreteHandlerA\n", request);
    }

    // такой себе микс ChainOfResponsibility и TemplateMethod получился
    // и классно ведь!
    // но это не все - идем в Main
}