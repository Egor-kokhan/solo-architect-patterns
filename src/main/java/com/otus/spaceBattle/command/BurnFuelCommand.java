package com.otus.spaceBattle.command;

import com.otus.spaceBattle.action.BurnFuel;
import com.otus.spaceBattle.action.Command;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BurnFuelCommand implements Command {

    private final BurnFuel burnFuel;

    @Override
    public void execute() {
        int rate = burnFuel.getFuelConsumptionRate();
        int fuel = burnFuel.getCurrentFuel();
        burnFuel.setCurrentFuel(fuel - rate);
    }

}