package com.anbo.juja.patterns.command_08.sample.list.command.linkedlist;

import ua.com.juja.patterns.command.sample.list.Command;
import ua.com.juja.patterns.command.sample.list.LinkedListReceiver;

/**
 * Created by oleksandr.baglai on 08.10.2015.
 */
public class Size implements Command {

    private LinkedListReceiver receiver;

    public Size(LinkedListReceiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public Integer execute(Object... args) {
        if (args.length != 0) {
            throw new IllegalArgumentException(
                    "Неверный формат вызова команды, ожидается вызов без параметров");
        }

        int count = 0;
        LinkedListReceiver.Node node = receiver.getFirst();
        while (node != null) {
            count++;
            node = node.next;
        }

        return count;
    }
}
