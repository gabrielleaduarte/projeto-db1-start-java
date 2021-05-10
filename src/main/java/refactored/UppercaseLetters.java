package refactored;

public class UppercaseLetters {

    int countUppercaseLetters;

    public int lengthUppercaseLetters(String[] candidateArray) {
        for (String s : candidateArray) {
            if (s.matches("[A-Z]")) {
                countUppercaseLetters++;
            }
        }
        return countUppercaseLetters;
    }
    public int bonusUppercaseLetters(int countLowercaseLetters, int countLength) {
        int multiplierUppercaseLetters = 2;
        if (countUppercaseLetters > 0 && countLowercaseLetters < countLength) {
            return (countLength - countLowercaseLetters) * multiplierUppercaseLetters;
        } else {
            return 0;
        }
    }
}
