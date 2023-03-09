package com.otus.spaceBattle.exceptionHandler;

import com.otus.spaceBattle.action.Command;
import com.otus.spaceBattle.command.LogCommand;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.LinkedList;
import java.util.Queue;

class LogHandlerTest {

    @Test
    void handle() {
        //given
        LogHandler logHandler = new LogHandler();
        Exception e = Mockito.mock(Exception.class);
        Command move = Mockito.mock(Command.class);
        Queue<Command> queue = new LinkedList<>();

        //when
        logHandler.handle(e, move, queue);

        //then
        Assertions.assertEquals(1, queue.size());
        Assertions.assertTrue(queue.peek() instanceof LogCommand);
    }
}