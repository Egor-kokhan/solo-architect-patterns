package com.otus.spaceBattle.command;

import com.otus.spaceBattle.action.Command;
import com.otus.spaceBattle.exception.CommandException;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Queue;

@RequiredArgsConstructor
public class LongDurationMoveCommand implements Command, Stoppable {

    @NonNull
    private final Queue<Command> queue;
    @NonNull
    private final MoveForwardWithBurnFuelCommand moveCommand;
    private boolean isStop = false;

    @Override
    public void execute() {
        try {
            while (!isStop) {
                CommandSetterInQueueCommand setterCommand = new CommandSetterInQueueCommand(queue, moveCommand);
                setterCommand.execute();
            }
        } catch (Exception e) {
            throw new CommandException("Process LongDurationMove was finished with exception: " + e.getMessage(), e);
        }
    }

    @Override
    public void stopCommand() {
        isStop = true;
    }


}
