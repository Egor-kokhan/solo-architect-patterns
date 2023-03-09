package com.otus.spaceBattle.command;

import com.otus.spaceBattle.action.Command;
import com.otus.spaceBattle.exception.CommandException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

class MacroCommandTest {


    @Test
    void execute_shouldCallExecuteInAllListCommands() {
        //given
        Command command1 = Mockito.mock(Command.class);
        Command command2 = Mockito.mock(Command.class);
        Command command3 = Mockito.mock(Command.class);
        List<Command> queue = List.of(command1, command2, command3);
        MacroCommand macroCommand = new MacroCommand(queue);

        //when
        macroCommand.execute();

        //then
        Mockito.verify(command1).execute();
        Mockito.verify(command2).execute();
        Mockito.verify(command3).execute();
    }


    @Test
    void execute_ifInnerCommandHasAnyExcMacroCommandHasCommandException() {
        //given
        Command command1 = Mockito.mock(Command.class);
        Command command2 = Mockito.mock(Command.class);
        Mockito.doThrow(CommandException.class).when(command2).execute();
        List<Command> queue = List.of(command1, command2);
        MacroCommand macroCommand = new MacroCommand(queue);

        //when -> then
        Assertions.assertThrows(CommandException.class, macroCommand::execute);
    }


}