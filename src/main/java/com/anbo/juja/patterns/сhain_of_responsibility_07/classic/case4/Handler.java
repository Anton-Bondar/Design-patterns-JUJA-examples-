package com.anbo.juja.patterns.сhain_of_responsibility_07.classic.case4;

/**
 * Created by oleksandr.baglai on 24.09.2015.
 */
// мы выделили абстракцию
// помнишь те самые два абстрактных метода в прошлом Handler? они теперь тут
public interface Handler {

    // а клиенты пусть реализуют обработчик
    void handle(Request request);

    // и сами решают, можгут ли они обработать этот запрос
    boolean canHandle(Request request);
}
