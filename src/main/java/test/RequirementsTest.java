package test;

import org.junit.jupiter.api.Test;
import refactored.*;


import static org.junit.jupiter.api.Assertions.*;

class RequirementsTest {

    private final String password = "ABC#$%abc123";
    private final String[] arrPwd = password.replaceAll("\\s+", "").split("\\s*");
    private final NumberOfCharacters numberOfCharacters = new NumberOfCharacters(password);
    private final UppercaseLetters uppercaseLetters = new UppercaseLetters(arrPwd, numberOfCharacters.getCountLength());
    private final LowercaseLetters lowercaseLetters = new LowercaseLetters(arrPwd, numberOfCharacters.getCountLength());
    private final Numbers numbers = new Numbers(arrPwd, numberOfCharacters.getCountLength());
    private final Symbols symbols = new Symbols(arrPwd);

    @Test
    void shouldReturnRequirementsOfPassword(){
        int expectedValue = 5;
        Requirements requirements = new Requirements(numberOfCharacters.getCountLength(), uppercaseLetters.getCountUppercaseLetters(),
                lowercaseLetters.getCountLowercaseLetters(), numbers.getCountNumbers(), symbols.getCountSymbols(), password);
        assertEquals(expectedValue, requirements.getCountRequirements());
    }

    @Test
    void shouldReturnTheBonusOfRequirements(){
        int expectedValue = 10;
        Requirements requirements = new Requirements(numberOfCharacters.getCountLength(), uppercaseLetters.getCountUppercaseLetters(),
                lowercaseLetters.getCountLowercaseLetters(), numbers.getCountNumbers(), symbols.getCountSymbols(), password);
        assertEquals(expectedValue, requirements.getBonusRequirements());
    }
}