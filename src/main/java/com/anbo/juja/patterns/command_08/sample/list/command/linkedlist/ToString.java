package com.anbo.juja.patterns.command_08.sample.list.command.linkedlist;

import ua.com.juja.patterns.command.sample.list.Command;
import ua.com.juja.patterns.command.sample.list.LinkedListReceiver;

/**
 * Created by oleksandr.baglai on 08.10.2015.
 */
public class ToString implements Command {

    private LinkedListReceiver receiver;

    public ToString(LinkedListReceiver receiver) {
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

        LinkedListReceiver.Node node = receiver.getFirst();
        while (node != null) {
            result.append(node.value);
            if (node.next != null) {
                result.append(", ");
            }
            node = node.next;
        }

        result.append(']');
        return result.toString();
    }
}
