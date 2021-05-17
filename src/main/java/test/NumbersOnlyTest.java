package test;

import org.junit.jupiter.api.Test;
import refactored.*;

import static org.junit.jupiter.api.Assertions.*;

class NumbersOnlyTest {

    private final String password = "123456";
    private final String[] arrPwd = password.replaceAll("\\s+", "").split("\\s*");
    private final NumberOfCharacters numberOfCharacters = new NumberOfCharacters(password);
    private final UppercaseLetters uppercaseLetters = new UppercaseLetters(arrPwd, numberOfCharacters.getCountLength());
    private final LowercaseLetters lowercaseLetters = new LowercaseLetters(arrPwd, numberOfCharacters.getCountLength());
    private final Numbers numbers = new Numbers(arrPwd, numberOfCharacters.getCountLength());
    private final Symbols symbols = new Symbols(arrPwd);

    @Test
    void shouldReturnNumbersOnlyOfPassword(){
        int expectedValue = 6;
        NumbersOnly numbersOnly = new NumbersOnly(numberOfCharacters.getCountLength(), lowercaseLetters.getCountLowercaseLetters(),
                uppercaseLetters.getCountUppercaseLetters(), symbols.getCountSymbols(), numbers.getCountNumbers());
        assertEquals(expectedValue, numbersOnly.getCountNumbersOnly());
    }

    @Test
    void shouldReturnTheBonusOfNumbersOnly(){
        int expectedValue = 6;
        NumbersOnly numbersOnly = new NumbersOnly(numberOfCharacters.getCountLength(), lowercaseLetters.getCountLowercaseLetters(),
                uppercaseLetters.getCountUppercaseLetters(), symbols.getCountSymbols(), numbers.getCountNumbers());
        assertEquals(expectedValue, numbersOnly.getBonusNumbersOnly());
    }

}