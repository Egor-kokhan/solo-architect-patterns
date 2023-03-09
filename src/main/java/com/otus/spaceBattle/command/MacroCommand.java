package com.otus.spaceBattle.command;

import com.otus.spaceBattle.action.Command;
import com.otus.spaceBattle.exception.CommandException;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class MacroCommand implements Command {

    @NonNull
    private final List<Command> commandList;

    @Override
    public void execute() {
        try {
            commandList.forEach(Command::execute);
        } catch (Exception e) {
            throw new CommandException("Process marco command was finished with exception: " + e.getMessage(), e);
        }
    }

}
