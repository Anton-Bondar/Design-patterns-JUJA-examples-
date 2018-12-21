package com.anbo.juja.patterns.command_08.sample.sqlcmd.command;

/**
 * Created by oleksandr.baglai on 28.08.2015.
 */
public interface Command {

    boolean canProcess(String command);

    void process(String command);

    String description();

    String format();
}
