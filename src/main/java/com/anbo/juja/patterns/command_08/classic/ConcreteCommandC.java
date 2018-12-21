package com.anbo.juja.patterns.command_08.classic;

/**
 * Created by oleksandr.baglai on 08.10.2015.
 */
// еще одна команда
public class ConcreteCommandC implements Command {
    private ReceiverA receiver;

    // работает с тем же receiver, что и первая
    public ConcreteCommandC(ReceiverA receiver) {
        this.receiver = receiver;
    }

    @Override
    // но инкапсулирует другую логику
    public Object execute(Object input) {
        return receiver.method2("Changed in CommandC: " + input);
    }
}
