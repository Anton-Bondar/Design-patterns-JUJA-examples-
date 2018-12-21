package com.anbo.juja.patterns.command_08.sample.sqlcmd.command;

import ua.com.juja.patterns.command.sample.sqlcmd.View;

/**
 * Created by oleksandr.baglai on 28.08.2015.
 */
public class Unsupported extends Processor {

    private View view;

    public Unsupported(View view) {
        this.view = view;
    }

    @Override
    public boolean canProcess(String command) {
        return true;
    }

    @Override
    public void process(String command) {
        view.write("Несуществующая команда: " + command);
    }
}
