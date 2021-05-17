package test;

import org.junit.jupiter.api.Test;
import refactored.LowercaseLetters;
import refactored.NumberOfCharacters;

import static org.junit.jupiter.api.Assertions.*;

class LowercaseLettersTest {

    private final String password = "ABC#$%abc123";
    private final String[] arrPwd = password.replaceAll("\\s+", "").split("\\s*");
    private final NumberOfCharacters numberOfCharacters = new NumberOfCharacters(password);

    @Test
    void shouldReturnLowercaseLettersOfPassword(){
        int expectedValue = 3;
        LowercaseLetters lowercaseLetters = new LowercaseLetters(arrPwd, numberOfCharacters.getCountLength());
        assertEquals(expectedValue, lowercaseLetters.getCountLowercaseLetters());
    }

    @Test
    void shouldReturnTheBonusOfLowercaseLettersOfPassword(){
        int expectedValue = 18;
        LowercaseLetters lowercaseLetters = new LowercaseLetters(arrPwd, numberOfCharacters.getCountLength());
        assertEquals(expectedValue, lowercaseLetters.getBonusLowercaseLetters());
    }
}