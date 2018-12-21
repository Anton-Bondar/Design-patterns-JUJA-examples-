package com.anbo.juja.patterns.сhain_of_responsibility_07.classic.case3;

import org.junit.Before;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * Created by oleksandr.baglai on 30.09.2015.
 */
public abstract class ConcreteHandlerTest {

    // так как один из обработчиков печатает нагло в консоль, мы ее замокаем
    // для этого нам потребуется этот малый
    protected ByteArrayOutputStream out = new ByteArrayOutputStream();

    // тут мы будем хранить запрос, который дошел до второго обработчика
    protected Request processed;

    // тут наш главный тестируемый обработчик
    protected Handler handler;

    @Before
    public void setup() {
        // переопределяем консоль
        System.setOut(new PrintStream(out));

        // given
        // создаем тестируемый обработчик
        handler = getHandler();

        // ставим для него следующий фейковый обработчик в очередь
        handler.setSuccessor(new Handler() {
            @Override
            protected boolean canHandle(Request request) {
                // берется обработать
                return true;
            }

            @Override
            public void handle(Request request) {
                // он просто сохранит то, что ему передали
                processed = request;
            }
        });
    }

    // помнишь зачем этот метод в template method шаблоне?
    protected abstract Handler getHandler();
}
