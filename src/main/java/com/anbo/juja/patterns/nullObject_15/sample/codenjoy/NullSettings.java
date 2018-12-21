package com.anbo.juja.patterns.nullObject_15.sample.codenjoy;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by oleksandr.baglai on 10.12.2015.
 */
public class NullSettings implements Settings {
    @Override
    public List<Parameter<?>> getParameters() {
        // нате пустой список, делайте что хотите!
        return new LinkedList<>();
    }

    // и параметров пачку - тоже пустые все

    @Override
    public Parameter<?> addEditBox(String name) {
        return Parameter.NULL;
    }

    @Override
    public Parameter<?> addSelect(String name, List<Object> strings) {
        return Parameter.NULL;
    }

    @Override
    public Parameter<Boolean> addCheckBox(String name) {
        return (Parameter<Boolean>) Parameter.NULL;
    }

    @Override
    public Parameter<?> getParameter(String name) {
        return Parameter.NULL;
    }
}
