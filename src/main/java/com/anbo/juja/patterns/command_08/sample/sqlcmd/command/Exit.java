package com.anbo.juja.patterns.command_08.sample.sqlcmd.command;

import ua.com.juja.patterns.command.sample.sqlcmd.View;

/**
 * Created by oleksandr.baglai on 28.08.2015.
 */
public class Exit implements Command {

    private View view;

    public Exit(View view) {
        this.view = view;
    }

    @Override
    public boolean canProcess(String command) {
        return command.equals(format());
    }

    @Override
    public String description() {
        return "Выход из программы";
    }

    @Override
    public String format() {
        return "exit";
    }

    @Override
    public void process(String command) {
        view.write("До скорой встречи!");
        throw new ExitException();
    }
}
