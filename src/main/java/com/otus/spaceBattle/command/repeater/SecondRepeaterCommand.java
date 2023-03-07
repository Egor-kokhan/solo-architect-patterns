package com.otus.spaceBattle.command.repeater;

import com.otus.spaceBattle.action.Command;
import com.otus.spaceBattle.exception.SecondRepeatException;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SecondRepeaterCommand implements Command {

    private final Command command;

    @Override
    public void execute() {
        try {
            command.execute();
        } catch (Exception e) {
            throw new SecondRepeatException(e);
        }
    }

}
