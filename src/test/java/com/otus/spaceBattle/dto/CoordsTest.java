package com.otus.spaceBattle.dto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.otus.spaceBattle.TestData.*;

class CoordsTest {

    @Test
    void append_shouldReturnNewPosition() {
        //when
        Coords calcPosition = Coords.append(START_POSITION, VELOCITY);

        Assertions.assertEquals(END_POSITION, calcPosition);
    }

    @Test
    void append_shouldThrowException_ifPositionIsNull() {
        //when - then exception
        Assertions.assertThrows(RuntimeException.class, () -> Coords.append(null, VELOCITY));
    }

    @Test
    void append_shouldThrowException_ifVelocityIsNull() {
        //when - then exception
        Assertions.assertThrows(RuntimeException.class, () -> Coords.append(START_POSITION, null));
    }
}