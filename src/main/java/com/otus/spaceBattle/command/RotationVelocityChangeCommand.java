package com.otus.spaceBattle.command;

import com.otus.spaceBattle.action.Command;
import com.otus.spaceBattle.action.RotationVelocityChangeable;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RotationVelocityChangeCommand implements Command {

    private final @NonNull RotationVelocityChangeable rotationVelocityChangeable;

    @Override
    public void execute() {
        int angularVelocity = rotationVelocityChangeable.getAngularVelocity();
        int angularVelocityChange = rotationVelocityChangeable.getAngularVelocityChange();
        rotationVelocityChangeable.setAngularVelocity(angularVelocity + angularVelocityChange);
    }
}
