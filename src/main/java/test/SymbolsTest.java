package test;

import org.junit.jupiter.api.Test;
import refactored.Symbols;

import static org.junit.jupiter.api.Assertions.*;

class SymbolsTest {

    private final String password = "ABC#$%abc123";
    private final String[] arrPwd = password.replaceAll("\\s+", "").split("\\s*");

    @Test
    void shouldReturnNumbersOfPassword(){
        int expectedValue = 3;
        Symbols symbols = new Symbols(arrPwd);
        assertEquals(expectedValue, symbols.getCountSymbols());
    }

    @Test
    void shouldReturnTheBonusOfNumbers(){
        int expectedValue = 18;
        Symbols symbols = new Symbols(arrPwd);
        assertEquals(expectedValue, symbols.getBonusSymbols());
    }
}