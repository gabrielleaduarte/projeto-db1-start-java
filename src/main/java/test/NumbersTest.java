package test;

import org.junit.jupiter.api.Test;
import refactored.Numbers;
import refactored.NumberOfCharacters;

import static org.junit.jupiter.api.Assertions.*;

class NumbersTest {

    private final String password = "ABC#$%abc123";
    private final String[] arrPwd = password.replaceAll("\\s+", "").split("\\s*");
    private final NumberOfCharacters numberOfCharacters = new NumberOfCharacters(password);

    @Test
    void shouldReturnNumbersOfPassword(){
        int expectedValue = 3;
        Numbers numbers = new Numbers(arrPwd, numberOfCharacters.getCountLength());
        assertEquals(expectedValue, numbers.getCountNumbers());
    }

    @Test
    void shouldReturnTheBonusOfNumbers(){
        int expectedValue = 12;
        Numbers numbers = new Numbers(arrPwd, numberOfCharacters.getCountLength());
        assertEquals(expectedValue, numbers.getBonusNumbers());
    }
}