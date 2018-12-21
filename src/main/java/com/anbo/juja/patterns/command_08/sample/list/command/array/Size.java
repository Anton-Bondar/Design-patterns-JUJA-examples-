package com.anbo.juja.patterns.command_08.sample.list.command.array;

import ua.com.juja.patterns.command.sample.list.ArrayReceiver;
import ua.com.juja.patterns.command.sample.list.Command;

/**
 * Created by oleksandr.baglai on 08.10.2015.
 */
public class Size implements Command {

    private ArrayReceiver receiver;

    public Size(ArrayReceiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public Integer execute(Object... args) {
        if (args.length != 0) {
            throw new IllegalArgumentException(
                    "Неверный формат вызова команды, ожидается вызов без параметров");
        }

        return receiver.size();
    }
}
