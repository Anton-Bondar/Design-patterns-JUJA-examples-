package com.anbo.juja.patterns.command_08.sample.sqlcmd.command;

import ua.com.juja.patterns.command.sample.sqlcmd.View;

/**
 * Created by oleksandr.baglai on 28.08.2015.
 */
public class Help implements Command {

    private View view;
    private Command[] commands;

    public Help(View view) {
        this.view = view;
    }

    @Override
    public boolean canProcess(String command) {
        return command.equals("help");
    }

    @Override
    public String description() {
        return "Вывод списка команд";
    }

    @Override
    public String format() {
        return "help";
    }

    @Override
    public void process(String input) {
        view.write("Существующие команды:");
        for (Command command : commands) {
            if (command.format() == null) continue;
            view.write("\t" + command.format());
            view.write("\t\t" + command.description());
        }
    }

    public void setCommands(Command[] commands) {
        this.commands = commands;
    }
}
