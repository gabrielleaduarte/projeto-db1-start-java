package test;

import org.junit.jupiter.api.Test;
import refactored.NumberOfCharacters;

import static org.junit.jupiter.api.Assertions.*;

class NumberOfCharactersTest {

    @Test
    void shouldReturnNumberOfCharacters() {

        int expectedValue = 12;

        NumberOfCharacters numberOfCharacters = new NumberOfCharacters("ABC#$%abc123");

        assertEquals(expectedValue, numberOfCharacters.getCountLength());

    }
}