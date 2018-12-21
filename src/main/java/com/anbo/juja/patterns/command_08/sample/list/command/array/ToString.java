package com.anbo.juja.patterns.command_08.sample.list.command.array;

import ua.com.juja.patterns.command.sample.list.ArrayReceiver;
import ua.com.juja.patterns.command.sample.list.Command;

/**
 * Created by oleksandr.baglai on 08.10.2015.
 */
public class ToString implements Command {

    private ArrayReceiver receiver;

    public ToString(ArrayReceiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public String execute(Object... args) {
        if (args.length != 0) {
            throw new IllegalArgumentException(
                    "Неверный формат вызова команды, ожидается вызов без параметров");
        }

        StringBuffer result = new StringBuffer();
        result.append('[');

        for (int index = 0; index < receiver.size(); index++) {
            result.append(receiver.get(index));
            if (index != receiver.size() - 1) {
                result.append(", ");
            }
        }

        result.append(']');
        return result.toString();
    }
}
