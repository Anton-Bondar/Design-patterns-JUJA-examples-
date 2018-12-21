package com.anbo.juja.patterns.decorator_02.interfaces;

import com.anbo.juja.patterns.decorator_02.classic.Decorator;

/**
 * Created by oleksandr.baglai on 26.08.2015.
 */
public class ConcreteDecoratorB implements Component {

    private Component component;

    public ConcreteDecoratorB(Component component) {
        this.component = component;
    }

    @Override
    public Object operation(Object input) {
        System.out.printf("Call ConcreteDecoratorB.operation('%s')\n", input);

        Object result = "[before]" + addedBehaviour(input) + "[after]";

        System.out.printf("Exit ConcreteDecoratorB.operation() with '%s'\n", result);
        return result;
    }

    public Object addedBehaviour(Object input) {
        System.out.printf("Call ConcreteDecoratorB.addedBehaviour('%s')\n", input);

        String result = component.operation(input).toString().toUpperCase();

        System.out.printf("Exit ConcreteDecoratorB.addedBehaviour() with '%s'\n", result);
        return result;
    }
}
