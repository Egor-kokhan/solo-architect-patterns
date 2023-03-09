package com.otus.spaceBattle.exceptionHandler;

import com.otus.spaceBattle.action.Command;

import java.util.Queue;

public interface OtusExceptionHandler {

    void handle(Exception e, Command command, Queue<Command> commandQueue);

}
