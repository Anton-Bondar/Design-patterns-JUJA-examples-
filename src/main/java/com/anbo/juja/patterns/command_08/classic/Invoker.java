package com.anbo.juja.patterns.command_08.classic;

/**
 * Created by oleksandr.baglai on 08.10.2015.
 */
// а это наш выполнятор, он будет выполнять команды
public class Invoker {
    // он хранит команду как абстракцию
    private Command command;

    // и с ней он агрегат - то есть ее можно заменить в runtime
    public void setCommand(Command command) {
        this.command = command;
    }

    // а это его единственный метод, его будет дергать клиент
    public void doit() {
        System.out.println(command.execute("data"));
    }
}
