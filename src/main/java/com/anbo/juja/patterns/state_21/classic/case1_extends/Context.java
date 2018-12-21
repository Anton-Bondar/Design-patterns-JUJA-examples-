package com.anbo.juja.patterns.state_21.classic.case1_extends;

/**
 * Created by oleksandr.baglai on 22.02.2016.
 */
public class Context {

    // храним состояние объекта
    private State state;

    // устанавливаем состояние по умолчанию
    public Context() {
        setState(new ConcreteStateA());
    }

    // этот запрос хочет клиент выполнить
    public void request(String data) {
        state.handle(this, data);
    }

    // скрытый (видимый только в пакете) сеттер,
    // поскольку конкретное состояние может изменить состояние
    // объекта Context но никто за пределами пакета
    // не может этого делать
    void setState(State state) {
        String name = state.getClass().getSimpleName();
        System.out.println("Set state: " + name.charAt(name.length() - 1));
        this.state = state;
    }
}
