package com.anbo.juja.patterns.command_08.sample.sqlcmd.command;

import ua.com.juja.patterns.command.sample.sqlcmd.DatabaseManager;
import ua.com.juja.patterns.command.sample.sqlcmd.View;

import java.util.Set;

/**
 * Created by oleksandr.baglai on 28.08.2015.
 */
public class Tables implements Command {

    private DatabaseManager manager;
    private View view;

    public Tables(DatabaseManager manager, View view) {
        this.manager = manager;
        this.view = view;
    }

    @Override
    public boolean canProcess(String command) {
        return command.equals("tables");
    }

    @Override
    public String description() {
        return "Вывод всех таблиц базы";
    }

    @Override
    public String format() {
        return "tables";
    }

    @Override
    public void process(String command) {
        Set<String> tableNames = manager.getTableNames();

        view.write(tableNames.toString());
    }
}
