package edu.touro.cs.mcon364;

import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.*;

class CaesarCypherTest {

    @org.junit.jupiter.api.Test
    void encrypt() {
        String actual = CaesarCypher.encrypt("HAL", 1);
        Assertions.assertEquals("IBM", actual);
    }


    @org.junit.jupiter.api.Test()
    void encryptThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> CaesarCypher.encrypt("HAL", 100));
        assertEquals("Shift must be in range 0-25", exception.getMessage());
    }
}