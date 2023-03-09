package com.otus.spaceBattle.command;

import com.otus.spaceBattle.action.Command;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.LinkedList;
import java.util.Queue;

class CommandSetterInQueueCommandTest {

    @Test
    void execute_shouldAddCommandToQueue() {
        Command command = Mockito.mock(Command.class);
        Queue<Command> queue = new LinkedList<>();
        CommandSetterInQueueCommand commandSetterInQueueCommand = new CommandSetterInQueueCommand(queue, command);

        commandSetterInQueueCommand.execute();

        Assertions.assertEquals(command, queue.peek());
    }

    @Test
    void execute_shouldAThrowExceptionIfCommandOrQueueIsNull() {
        //given
        Command command = Mockito.mock(Command.class);
        Queue<Command> queue = new LinkedList<>();

        //when -> then
        Assertions.assertThrows(NullPointerException.class, () -> {
            new CommandSetterInQueueCommand(null, command);
        });

        //when -> then
        Assertions.assertThrows(NullPointerException.class, () -> {
            new CommandSetterInQueueCommand(queue, null);
        });

    }

}