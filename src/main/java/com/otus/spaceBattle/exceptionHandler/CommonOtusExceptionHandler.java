package com.otus.spaceBattle.exceptionHandler;

import com.otus.spaceBattle.action.Command;
import lombok.extern.slf4j.Slf4j;

import java.util.Queue;

@Slf4j
public class CommonOtusExceptionHandler implements OtusExceptionHandler {
    @Override
    public void handle(Exception e, Command command, Queue<Command> commandQueue) {
        log.error("unknown exception in command {} : {}", command.getClass(), e.getMessage());
    }
}
