package test;

import org.junit.jupiter.api.Test;
import refactored.NumberOfCharacters;

import static org.junit.jupiter.api.Assertions.*;

class NumberOfCharactersTest {

    private String password = "ABC#$%abc123";

    @Test
    void shouldReturnNumberOfCharactersOfPassword() {
        int expectedValue = 12;
        NumberOfCharacters numberOfCharacters = new NumberOfCharacters(password);
        assertEquals(expectedValue, numberOfCharacters.getCountLength());
    }

    @Test
    void shouldReturnTheBonusOfNumberOfCharacters() {
        int expectedValue = 48;
        NumberOfCharacters numberOfCharacters = new NumberOfCharacters(password);
        assertEquals(expectedValue, numberOfCharacters.getBonusLength());
    }
}