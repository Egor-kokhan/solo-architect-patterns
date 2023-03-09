package com.otus.spaceBattle.command;

import com.otus.spaceBattle.action.Command;
import com.otus.spaceBattle.action.Movable;
import com.otus.spaceBattle.dto.Coords;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MoveCommand implements Command {
    private final Movable movable;

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
