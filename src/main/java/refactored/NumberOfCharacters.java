package refactored;

public class NumberOfCharacters {

    public int lengthNumberOfCharacters(String candidate) {
        return candidate.length();
    }
    public int bonusNumberOfCharacters(String candidate) {
        int multiplierLength = 4;
        int countLength = candidate.length();
        return multiplierLength * countLength;
    }
}