package com.otus.spaceBattle.command;

import com.otus.spaceBattle.action.Command;
import com.otus.spaceBattle.action.Movable;
import com.otus.spaceBattle.dto.Coords;

public class MoveCommand implements Command {
    private final Movable movable;

    public MoveCommand(Movable movable) {
        this.movable = movable;
    }

    @Override
    public void execute() {
        Coords position = movable.getPosition();
        Coords velocity = movable.getVelocity();
        if (velocity == null || position == null) {
            throw new NullPointerException();
        }

        movable.setPosition(Coords.append(position, velocity));
    }
}
