package com.anbo.juja.patterns.nullObject_15.sample.codenjoy;

/**
 * Created by oleksandr.baglai on 10.12.2015.
 */
// абстракция параметра, чтобы из админки можно было менять
// обычно это просто обертка над примитивом
public interface Parameter<T> {

    // тоже синглтончик (смотри Game.NULL - там объяснение)
    Parameter<?> NULL = new NullParameter();

    T getValue();

    String getName();

    void update(T value);
}
