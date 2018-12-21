package com.anbo.juja.patterns.command_08.sample.list.command.array;

import ua.com.juja.patterns.command.sample.list.ArrayReceiver;
import ua.com.juja.patterns.command.sample.list.Command;

/**
 * Created by oleksandr.baglai on 08.10.2015.
 */
public class IsEmpty implements Command {

    private ArrayReceiver receiver;

    public IsEmpty(ArrayReceiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public Boolean execute(Object... args) {
        if (args.length != 0) {
            throw new IllegalArgumentException(
                    "Неверный формат вызова команды, ожидается вызов без параметров");
        }

        return receiver.size() == 0;
    }
}
