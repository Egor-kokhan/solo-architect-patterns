package com.otus.spaceBattle.command.repeater;

import com.otus.spaceBattle.action.Command;
import com.otus.spaceBattle.exception.OtusRuntimeException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class SecondRepeaterCommandTest {

    @Mock
    private Command innerCommand;

    private SecondRepeaterCommand afterExceptionCommand;

    @BeforeEach
    public void beforeEach() {
        afterExceptionCommand = new SecondRepeaterCommand(innerCommand);
    }

    @Test
    void execute_run_inner_command() {
        afterExceptionCommand.execute();
        verify(innerCommand).execute();
    }

    @Test
    void execute_catchCommonCommandExceptionAndThrowRepeatExc() {
        doThrow(new OtusRuntimeException()).when(innerCommand).execute();

        Assertions.assertThrows(OtusRuntimeException.class, () -> afterExceptionCommand.execute());
    }
}