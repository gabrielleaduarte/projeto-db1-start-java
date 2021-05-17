package test;

import org.junit.jupiter.api.Test;
import refactored.MiddleNumbersOrSymbols;

import static org.junit.jupiter.api.Assertions.*;

class MiddleNumbersOrSymbolsTest {

    private final String password = "ABC#$%abc123";
    private final String[] arrPwd = password.replaceAll("\\s+", "").split("\\s*");

    @Test
    void shouldReturnMiddleNumbersOrSymbolsOfPassword(){
        int expectedValue = 5;
        MiddleNumbersOrSymbols middleNumbersOrSymbols = new MiddleNumbersOrSymbols(arrPwd);
        assertEquals(expectedValue, middleNumbersOrSymbols.getCountMiddleNumbersOrSymbols());
    }

    @Test
    void shouldReturnTheBonusOfMiddleNumbersOrSymbols(){
        int expectedValue = 10;
        MiddleNumbersOrSymbols middleNumbersOrSymbols = new MiddleNumbersOrSymbols(arrPwd);
        assertEquals(expectedValue, middleNumbersOrSymbols.getBonusMiddleNumberOrSymbols());
    }
}