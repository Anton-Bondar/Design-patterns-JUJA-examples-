package com.anbo.juja.patterns.сhain_of_responsibility_07.classic.case1;

import org.junit.Test;

import static junit.framework.TestCase.assertSame;

/**
 * Created by oleksandr.baglai on 30.09.2015.
 */
public class HandlerTest {

    // тут будем хранить тот риквест, что дойдет до второго обработчика
    // если дойдет конечно :)
    private Request processed = null;

    @Test
    public void shouldSendRequestToAccessor() {
        // given
        // наш первый обработчик
        Handler handler = new Handler() {
            @Override
            public void handleRequest(Request request) {
                // настроен передать все следующему
                successor.handleRequest(request);
            }
        };

        // его второй обработчик
        handler.setSuccessor(new Handler() {
            @Override
            public void handleRequest(Request request) {
                // сохранит риквест в поле
                processed = request;
            }
        });

        // наш риквест
        Request givenRequest = new Request("request");

        // when
        // послели по цепочке
        handler.handleRequest(givenRequest);

        // then
        // проверили, что риквест дошел
        assertSame(givenRequest, processed);
    }
}
