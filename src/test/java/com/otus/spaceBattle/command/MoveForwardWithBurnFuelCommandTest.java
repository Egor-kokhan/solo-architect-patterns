package com.otus.spaceBattle.command;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class MoveForwardWithBurnFuelCommandTest {

    @Test
    void execute_shouldCall3CertainCommand() {
        //given
        BurnFuelCommand burnCommand = Mockito.mock(BurnFuelCommand.class);
        CheckFuelCommand checkCommand = Mockito.mock(CheckFuelCommand.class);
        MoveCommand moveCommand = Mockito.mock(MoveCommand.class);
        MoveForwardWithBurnFuelCommand forwardCommand = new MoveForwardWithBurnFuelCommand(burnCommand, checkCommand, moveCommand);

        //when
        forwardCommand.execute();

        //then
        Mockito.verify(burnCommand).execute();
        Mockito.verify(checkCommand).execute();
        Mockito.verify(moveCommand).execute();
    }

    @Test
    void execute_shouldThrowExceptionIfOneOfTheCommandsIsNull() {
        //given
        BurnFuelCommand burnCommand = Mockito.mock(BurnFuelCommand.class);
        CheckFuelCommand checkCommand = Mockito.mock(CheckFuelCommand.class);
        MoveCommand moveCommand = Mockito.mock(MoveCommand.class);

        //when -> then
        Assertions.assertThrows(NullPointerException.class, () -> {
            new MoveForwardWithBurnFuelCommand(null, checkCommand, moveCommand);
        });

        //when -> then
        Assertions.assertThrows(NullPointerException.class, () -> {
            new MoveForwardWithBurnFuelCommand(burnCommand, null, moveCommand);
        });

        //when -> then
        Assertions.assertThrows(NullPointerException.class, () -> {
            new MoveForwardWithBurnFuelCommand(burnCommand, checkCommand, null);
        });

    }

}