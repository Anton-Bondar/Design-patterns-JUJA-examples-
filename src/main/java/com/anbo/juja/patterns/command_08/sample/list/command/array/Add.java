package com.anbo.juja.patterns.command_08.sample.list.command.array;

import ua.com.juja.patterns.command.sample.list.ArrayReceiver;
import ua.com.juja.patterns.command.sample.list.Command;

/**
 * Created by oleksandr.baglai on 08.10.2015.
 */
public class Add implements Command {

    private ArrayReceiver receiver;

    public Add(ArrayReceiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public Integer execute(Object... args) {
        if (args.length != 1 || !(args[0] instanceof String)) {
            throw new IllegalArgumentException(
                    "Неверный формат вызова команды, ожидается 1 параметр [String]");
        }

        String value = (String)args[0];

        int atIndex = receiver.size();
        receiver.copyOf(atIndex + 1);
        receiver.set(atIndex, value);

        return atIndex;
    }
}
