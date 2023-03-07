package com.otus.spaceBattle.exceptionHandler;

import com.otus.spaceBattle.action.Command;
import com.otus.spaceBattle.command.LogCommand;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Queue;

public class NotEnoughFuelForMovingOtusExceptionHandler implements OtusExceptionHandler {

    @Override
    public void handle(Exception e, Command command, Queue<Command> commandQueue) {
        commandQueue.add(new LogCommand(e));
    }
}
