package com.otus.spaceBattle.runner;

import com.otus.spaceBattle.command.Command;
import com.otus.spaceBattle.exceptionHandler.MainExceptionHandler;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Queue;

@RequiredArgsConstructor
public class CommandRunner {

    @NonNull
    private final Queue<Command> commandQueue;
    @NonNull
    private final MainExceptionHandler handler;

    public void run() {
        Command command;
        while ((command = commandQueue.poll()) != null) {
            try {
                command.execute();
            } catch (Exception e) {
                handler.handle(e, command, commandQueue);
            }
        }
    }

}
