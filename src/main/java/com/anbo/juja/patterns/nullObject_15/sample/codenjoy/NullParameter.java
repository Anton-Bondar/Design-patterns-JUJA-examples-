package com.anbo.juja.patterns.nullObject_15.sample.codenjoy;

import org.apache.commons.lang.StringUtils;

/**
 * Created by oleksandr.baglai on 10.12.2015.
 */
public class NullParameter implements Parameter<Object> {
    @Override
    public Object getValue() {
        // что-то новенькое!
        // но не возвращать жеж null
        // NPE может быть
        return new Object();
    }

    @Override
    public String getName() {
        // и имя у параметра = ""
        return StringUtils.EMPTY;
    }

    @Override
    public void update(Object value) {
        // do nothing
    }
}
