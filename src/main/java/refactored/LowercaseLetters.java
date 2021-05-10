package refactored;

public class LowercaseLetters {

    int countLowercaseLetters;

    public int lengthLowercaseLetters(String[] candidateArray) {
        for (String s : candidateArray) {
            if (s.matches("[a-z]")) {
                countLowercaseLetters++;
            }
        }
        return countLowercaseLetters;
    }
    public int bonusLowercaseLetters(int countLength) {
        int multiplierLowercaseLetters = 2;
        if (countLowercaseLetters > 0 && countLowercaseLetters < countLength) {
            return (countLength - countLowercaseLetters) * multiplierLowercaseLetters;
        } else {
            return 0;
        }
    }
}
