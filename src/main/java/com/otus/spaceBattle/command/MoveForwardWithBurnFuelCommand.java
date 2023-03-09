package com.otus.spaceBattle.command;

import com.otus.spaceBattle.action.Command;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class MoveForwardWithBurnFuelCommand implements Command {

    @NonNull
    private final BurnFuelCommand burnFuelCommand;

    @NonNull
    private final CheckFuelCommand checkFuelCommand;

    @NonNull
    private final MoveCommand moveCommand;

    @Override
    public void execute() {
        MacroCommand macroCommand = new MacroCommand(List.of(checkFuelCommand, moveCommand, burnFuelCommand));
        macroCommand.execute();
    }

}
