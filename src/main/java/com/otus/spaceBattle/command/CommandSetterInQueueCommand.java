package com.otus.spaceBattle.command;

import com.otus.spaceBattle.action.Command;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Queue;

@RequiredArgsConstructor
public class CommandSetterInQueueCommand implements Command {

    @NonNull
    private final Queue<Command> commands;

    @NonNull
    private final Command command;

    @Override
    public void execute() {
        commands.add(command);
    }

}
