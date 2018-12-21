package com.anbo.juja.patterns.command_08.sample.list.command.linkedlist;

import ua.com.juja.patterns.command.sample.list.Command;
import ua.com.juja.patterns.command.sample.list.LinkedListReceiver;

/**
 * Created by oleksandr.baglai on 08.10.2015.
 */
public class Add implements Command {

    private LinkedListReceiver receiver;

    public Add(LinkedListReceiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public Integer execute(Object... args) {
        if (args.length != 1 || !(args[0] instanceof String)) {
            throw new IllegalArgumentException(
                    "Неверный формат вызова команды, ожидается 1 параметр [String]");
        }

        String value = (String)args[0];

        LinkedListReceiver.Node last = receiver.getLast();

        if (last == null) {
            LinkedListReceiver.Node node = new LinkedListReceiver.Node();
            node.value = value;
            receiver.setFirst(node);
            receiver.setLast(node);
            return 0;
        }

        LinkedListReceiver.Node node = new LinkedListReceiver.Node();
        node.value = value;
        last.next = node;
        node.prev = last;
        receiver.setLast(node);

        // ну одна команда знает про другую, подумаешь :)
        // пахнет костылестроением однако, или нет, TODO как думаешь?
        return new Size(receiver).execute() - 1;
    }
}
