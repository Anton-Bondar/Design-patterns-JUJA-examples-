package com.anbo.juja.patterns.command_08.classic;

/**
 * Created by oleksandr.baglai on 08.10.2015.
 */
// Вторая команда
public class ConcreteCommandB implements Command {
    private ReceiverB receiver;

    // тоже композит, но с ReceiverB
    public ConcreteCommandB(ReceiverB receiver) {
        this.receiver = receiver;
    }

    @Override
    // она вольна делать со своим Receiver, что пожелает
    // Команда - это контроллер для Receiver
    // но делает что-то одно простое - одну команду
    public Object execute(Object input) {
        receiver.otherMethod(input);
        return "CommandB result";
    }
}
