package com.otus.spaceBattle.command;

import com.otus.spaceBattle.action.BurnFuel;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class BurnFuelCommandTest {


    @Test
    void execute_shouldSetCurrentFuelRight() {
        //given
        BurnFuel burnFuel = Mockito.mock(BurnFuel.class);
        Mockito.when(burnFuel.getCurrentFuel()).thenReturn(5);
        Mockito.when(burnFuel.getFuelConsumptionRate()).thenReturn(1);
        BurnFuelCommand burnFuelCommand = new BurnFuelCommand(burnFuel);

        //when
        burnFuelCommand.execute();

        //then
        Mockito.verify(burnFuel).getCurrentFuel();
        Mockito.verify(burnFuel).getFuelConsumptionRate();
        Mockito.verify(burnFuel).setCurrentFuel(Mockito.eq(4));
    }


}