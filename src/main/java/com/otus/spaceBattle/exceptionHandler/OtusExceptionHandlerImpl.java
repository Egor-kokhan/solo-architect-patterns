package com.otus.spaceBattle.exceptionHandler;

import com.otus.spaceBattle.action.Command;
import com.otus.spaceBattle.command.MoveCommand;
import com.otus.spaceBattle.exception.FirstRepeatException;
import com.otus.spaceBattle.exception.NotEnoughFuelException;
import com.otus.spaceBattle.exception.SecondRepeatException;
import org.apache.commons.lang3.tuple.Pair;

import java.util.*;

public class OtusExceptionHandlerImpl implements OtusExceptionHandler {

    private Map<Class<? extends Command>, List<OtusExceptionHandler>> commandHandlers = new HashMap<>();
    private Map<Class<? extends Exception>, List<OtusExceptionHandler>> excHandlers = new HashMap<>();
    private Map<Pair<Class<? extends Exception>, Class<? extends Command>>,
            List<OtusExceptionHandler>> commandAndExcHandlers = new HashMap<>();

    @Override
    public void handle(Exception e, Command command, Queue<Command> commandQueue) {
        List<OtusExceptionHandler> handlers = getHandlers(e, command);
        if (handlers.isEmpty()) {
            new CommonOtusExceptionHandler().handle(e, command, commandQueue);
        }
    }

    private List<OtusExceptionHandler> getHandlers(Exception e, Command command) {
        Class<? extends Exception> excClass = e.getClass();
        Class<? extends Command> commandClass = command.getClass();
        List<OtusExceptionHandler> handlers = new ArrayList<>();
        handlers.addAll(commandHandlers.get(commandClass));
        handlers.addAll(excHandlers.get(excClass));
        handlers.addAll(commandAndExcHandlers.get(Pair.of(excClass, commandClass)));

        return handlers;
    }

    public void initHandlers() {
        commandHandlers.put(MoveCommand.class, List.of(new MoveOtusExceptionHandler(), new FirstRepeaterOtusExceptionHandler()));
        excHandlers.put(Exception.class, List.of(new BaseOtusExceptionHandler()));
        excHandlers.put(FirstRepeatException.class, List.of(new SecondRepeaterOtusExceptionHandler()));
        excHandlers.put(SecondRepeatException.class, List.of(new LogHandler()));
        commandAndExcHandlers.put(Pair.of(NotEnoughFuelException.class, MoveCommand.class), List.of(new NotEnoughFuelForMovingOtusExceptionHandler()));
    }


}
