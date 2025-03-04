package com.otus.spaceBattle.command;

import com.otus.spaceBattle.action.Command;
import com.otus.spaceBattle.action.SpeedChangeable;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SpeedChangerCommand implements Command {

    private final @NonNull SpeedChangeable speedChangeable;

    @Override
    public void execute() {
        int speed = speedChangeable.getSpeed();
        int speedChange = speedChangeable.getSpeedChange();

        speedChangeable.setSpeed(speed + speedChange);
    }

}