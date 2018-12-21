package com.anbo.juja.patterns.nullObject_15.sample.codenjoy;

import java.util.List;

/**
 * Created by oleksandr.baglai on 10.12.2015.
 */
// настройки - контейнер для купы Parameter
public interface Settings {

    // тоже синглтончик (смотри Game.NULL - там объяснение)
    Settings NULL = new NullSettings();

    List<Parameter<?>> getParameters();

    Parameter<?> addEditBox(String name);

    Parameter<?> addSelect(String name, List<Object> strings);

    Parameter<Boolean> addCheckBox(String name);

    Parameter<?> getParameter(String name);
}
