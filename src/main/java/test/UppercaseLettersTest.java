package test;

import org.junit.jupiter.api.Test;
import refactored.NumberOfCharacters;
import refactored.UppercaseLetters;

import static org.junit.jupiter.api.Assertions.*;

class UppercaseLettersTest {

    private final String password = "ABC#$%abc123";
    private final String[] arrPwd = password.replaceAll("\\s+", "").split("\\s*");
    private final NumberOfCharacters numberOfCharacters = new NumberOfCharacters(password);

    @Test
    void shouldReturnUppercaseLettersOfPassword(){
        int expectedValue = 3;
        UppercaseLetters uppercaseLetters = new UppercaseLetters(arrPwd, numberOfCharacters.getCountLength());
        assertEquals(expectedValue, uppercaseLetters.getCountUppercaseLetters());
    }

    @Test
    void shouldReturnTheBonusOfUppercaseLetters() {
        int expectedValue = 18;
        UppercaseLetters uppercaseLetters = new UppercaseLetters(arrPwd, numberOfCharacters.getCountLength());
        assertEquals(expectedValue, uppercaseLetters.getBonusUppercaseLetters());
    }
}