package com.anbo.juja.patterns.command_08.classic;

/**
 * Created by oleksandr.baglai on 08.10.2015.
 */

// Первая команда
public class ConcreteCommandA implements Command {
    private ReceiverA receiver;

    // работает с ReceiverA
    // заметь это композит! команда без Receiver не может существовать
    //     иначе может быть NPE в методе execute
    public ConcreteCommandA(ReceiverA receiver) {
        this.receiver = receiver;
    }

    @Override
    // а тут логика того, что команда делает со своим Receiver
    public Object execute(Object input) {
        return receiver.method1(input);
    }
}
