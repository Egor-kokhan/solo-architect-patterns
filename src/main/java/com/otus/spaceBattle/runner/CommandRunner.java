package com.otus.spaceBattle.runner;

import com.otus.spaceBattle.action.Command;
import com.otus.spaceBattle.exceptionHandler.OtusExceptionHandler;
import lombok.AllArgsConstructor;

import java.util.Queue;

@AllArgsConstructor
public class CommandRunner {

    private Queue<Command> commandQueue;
    private OtusExceptionHandler exceptionHandler;


    public void run() {
        for (Command command : commandQueue) {
            try {
                command.execute();
            } catch (Exception e) {
                exceptionHandler.handle(e, command, commandQueue);
            }
        }
    }

}
