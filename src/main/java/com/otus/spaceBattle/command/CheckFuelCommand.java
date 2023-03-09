package com.otus.spaceBattle.command;

import com.otus.spaceBattle.action.BurnFuel;
import com.otus.spaceBattle.action.Command;
import com.otus.spaceBattle.exception.NotEnoughFuelException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CheckFuelCommand implements Command {

    private final BurnFuel burnFuel;

    @Override
    public void execute() {
        int rate = burnFuel.getFuelConsumptionRate();
        int fuel = burnFuel.getCurrentFuel();
        if (fuel < rate) {
            throw new NotEnoughFuelException(String.format("Not enough fuel, current fuel = %d , fuel consuption rate = %d", fuel, rate));
        }
    }

}
