package com.anbo.juja.patterns.state_21.classic.case2_implements;

/**
 * Created by oleksandr.baglai on 22.02.2016.
 */
// обстракиция состояния, может содержать методы по-умолчанию
public interface State {

    // вот как этот, чтобы сократить код в конкретныз состояниях-наследниках
    void handle1(String data);

    // тут могут быть и другие методы в зависимости от логики
    // суть их такая же как и handle, они (а скорее их перегрузки в наследниках)
    // делают что-то полезное и могут менять соятояние Context,
    // а могут и не менять :) Как решит state-объект

    String handle2();

    // ну и так далее...

    // SomeResult handle3(Context context, SomeInput data);
}
