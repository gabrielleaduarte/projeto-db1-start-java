package refactored;

public class SequencialNumbers {

    int countSequencialNumbers;

    public int lengthSequencialNumbers(String candidateArray) {
        for (int i = 0; i < 8; i++) {
            String DIGITS = "01234567890";
            String sFwd = DIGITS.substring(i, i + 3);
            String sRev = new StringBuilder(sFwd).reverse().toString();
            if (candidateArray.toLowerCase().contains(sFwd) || candidateArray.toLowerCase().contains(sRev)) {
                countSequencialNumbers++;
            }
        }
        return countSequencialNumbers;
    }
    public int bonusSequencialNumbers() {
        int multiplierConsecutiveUppercaseLetters = 3;
        if (countSequencialNumbers > 0) {
            return countSequencialNumbers * multiplierConsecutiveUppercaseLetters;
        } else {
            return 0;
        }
    }
}
