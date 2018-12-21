package com.anbo.juja.patterns.command_08.sample.sqlcmd;

import ua.com.juja.patterns.command.sample.sqlcmd.command.*;

/**
 * Created by oleksandr.baglai on 25.08.2015.
 */
public class Main {

    public static void main(String[] args) {
        View view = new Console();
        DatabaseManager manager = new InMemoryDatabaseManager();

        Help help = new Help(view);
        Command[] commands = {
                new Connect(manager, view),
                help,
                new Exit(view),
                new IsConnected(manager, view),
                new Tables(manager, view),
                new Clear(manager, view),
                new Remove(manager, view),
                new Create(manager, view),
                new Find(manager, view),
                new Unsupported(view)
        };
        help.setCommands(commands);

        MainController controller = new MainController(view, manager, commands);
        controller.run();
    }
}
