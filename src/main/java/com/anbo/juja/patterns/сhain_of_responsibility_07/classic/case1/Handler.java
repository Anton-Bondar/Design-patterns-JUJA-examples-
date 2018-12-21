package com.anbo.juja.patterns.сhain_of_responsibility_07.classic.case1;

/**
 * Created by oleksandr.baglai on 24.09.2015.
 */
// это наш абстрактный обработчик
// он вводит понятие цепочки
public abstract class Handler {

    // вот тут хранится следующий элемент
    protected Handler successor;

    // а так мы его устанавливаем
    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }

    // а тут наследники будут заботиться о том, как обрабатывать сигнал
    public abstract void handleRequest(Request request);
}
