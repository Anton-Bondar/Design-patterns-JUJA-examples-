package com.anbo.juja.patterns.decorator_02.classic;

/**
 * Created by oleksandr.baglai on 26.08.2015.
 */
public abstract class Decorator extends Component {

    private Component component;

    public Decorator(Component component) {
        this.component = component;
    }

    @Override
    public Object operation(Object input) {
        return component.operation(input);
    }
}
