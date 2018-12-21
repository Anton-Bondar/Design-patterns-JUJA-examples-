package com.anbo.juja.patterns.command_08.classic;

import org.junit.Test;
import ua.com.juja.patterns.command.ConsoleMock;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by oleksandr.baglai on 08.10.2015.
 */
public class InvokerTest {

    private ConsoleMock console = new ConsoleMock();

    private Object processed;
    private Object returned;

    @Test
    public void shouldCallCommand() {
        // given
        // наш подопытный invoker
        Invoker invoker = new Invoker();

        // создаем фейковую команду-зонд, который сохраняет в поля то,
        // что ему передали и возвращает то, что мы захотим.
        Command command = new Command() {
            @Override
            public Object execute(Object input) {
                processed = input;
                return returned;
            }
        };

        // вот что веррнет команда
        returned = "returned";

        // устанавливаем команду в invoker
        invoker.setCommand(command);

        // when
        // вызов тестового метода
        invoker.doit();

        // then
        // проверили что invoker напечатал то, что вернула команда
        assertEquals("returned\r\n", console.getOut());

        // + до команды дошел сигнал из invoker
        assertEquals("data", processed);
    }

    @Test
    public void shouldCallCommand_mockitoCase() {
        // given
        // наш подопытный invoker
        Invoker invoker = new Invoker();

        // создаем мок команды
        Command command = mock(Command.class);

        // вот что веррнет команда
        when(command.execute(anyObject())).thenReturn("returned");

        // устанавливаем команду в invoker
        invoker.setCommand(command);

        // when
        // вызов тестового метода
        invoker.doit();

        // then
        // проверили что invoker напечатал то, что вернула команда
        assertEquals("returned\r\n", console.getOut());

        // + до команды дошел сигнал из invoker
        verify(command).execute("data");
    }
}
