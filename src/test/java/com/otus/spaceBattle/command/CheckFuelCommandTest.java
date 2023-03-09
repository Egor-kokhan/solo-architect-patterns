package com.otus.spaceBattle.command;

import com.otus.spaceBattle.action.BurnFuel;
import com.otus.spaceBattle.exception.NotEnoughFuelException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class CheckFuelCommandTest {

    @Test
    void execute_shouldCallGetFuelAndGetRateMethods() {
        //given
        BurnFuel burnFuel = Mockito.mock(BurnFuel.class);
        CheckFuelCommand checkFuelCommand = new CheckFuelCommand(burnFuel);

        //when
        checkFuelCommand.execute();

        //then
        Mockito.verify(burnFuel).getCurrentFuel();
        Mockito.verify(burnFuel).getFuelConsumptionRate();
    }

    @Test
    void execute_shouldThrowCommandExceptionIfFuelMoreThenRate() {
        //given
        BurnFuel burnFuel = Mockito.mock(BurnFuel.class);
        Mockito.when(burnFuel.getCurrentFuel()).thenReturn(5);
        Mockito.when(burnFuel.getFuelConsumptionRate()).thenReturn(6);
        CheckFuelCommand checkFuelCommand = new CheckFuelCommand(burnFuel);

        //when -> then
        Assertions.assertThrows(NotEnoughFuelException.class,
                checkFuelCommand::execute);
    }

    @Test
    void execute_shouldNotThrowCommandExceptionIfFuelEqualsRate() {
        //given
        BurnFuel burnFuel = Mockito.mock(BurnFuel.class);
        Mockito.when(burnFuel.getCurrentFuel()).thenReturn(5);
        Mockito.when(burnFuel.getFuelConsumptionRate()).thenReturn(5);
        CheckFuelCommand checkFuelCommand = new CheckFuelCommand(burnFuel);

        //when -> then
        Assertions.assertDoesNotThrow(checkFuelCommand::execute);
    }

}