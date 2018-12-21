package com.anbo.juja.patterns.command_08.sample.list.command.linkedlist;

import ua.com.juja.patterns.command.sample.list.Command;
import ua.com.juja.patterns.command.sample.list.LinkedListReceiver;

/**
 * Created by oleksandr.baglai on 08.10.2015.
 */
public class IsEmpty implements Command {

    private LinkedListReceiver receiver;

    public IsEmpty(LinkedListReceiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public Boolean execute(Object... args) {
        if (args.length != 0) {
            throw new IllegalArgumentException(
                    "Неверный формат вызова команды, ожидается вызов без параметров");
        }

        return receiver.getFirst() == null;
    }
}
