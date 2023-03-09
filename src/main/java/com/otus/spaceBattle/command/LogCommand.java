package com.otus.spaceBattle.command;

import com.otus.spaceBattle.action.Command;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
@AllArgsConstructor
public class LogCommand implements Command {

    private final Exception exception;

    @Override
    public void execute() {
        log.error(exception.getMessage() + ": " + Arrays.toString(exception.getStackTrace()));
    }

}
