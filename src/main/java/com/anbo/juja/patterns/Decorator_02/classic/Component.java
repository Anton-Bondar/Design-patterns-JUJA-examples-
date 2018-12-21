package com.anbo.juja.patterns.decorator_02.classic;

/**
 * Created by oleksandr.baglai on 26.08.2015.
 */
public abstract class Component {

    public Object operation(Object input) {
        System.out.printf("Call Component.operation('%s')\n", input);

        Object result = input;

        System.out.printf("Exit Component.operation() with '%s'\n", result);
        return result;
    }

}
