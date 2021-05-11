package refactored;

public class SequencialNumbers {

    int bonusSequencialNumbers;
    int countSequencialNumbers;

    public SequencialNumbers(String candidateArray) {
        countLengthSequencialNumbers(candidateArray);
        calculateBonusSequencialNumbers();
    }

    public void countLengthSequencialNumbers(String candidateArray) {
        for (int i = 0; i < 8; i++) {
            String DIGITS = "01234567890";
            String sFwd = DIGITS.substring(i, i + 3);
            String sRev = new StringBuilder(sFwd).reverse().toString();
            if (candidateArray.toLowerCase().contains(sFwd) || candidateArray.toLowerCase().contains(sRev)) {
                countSequencialNumbers++;
            }
        }
    }

    public void calculateBonusSequencialNumbers() {
        int multiplierConsecutiveUppercaseLetters = 3;
        if (countSequencialNumbers > 0) {
            bonusSequencialNumbers = countSequencialNumbers * multiplierConsecutiveUppercaseLetters;
        } else {
            bonusSequencialNumbers = 0;
        }
    }

    public int getBonusSequencialNumbers() {
        return bonusSequencialNumbers;
    }

    public int getCountSequencialNumbers() {
        return countSequencialNumbers;
    }

    public void setBonusSequencialNumbers(int bonusSequencialNumbers) {
        this.bonusSequencialNumbers = bonusSequencialNumbers;
    }

    public void setCountSequencialNumbers(int countSequencialNumbers) {
        this.countSequencialNumbers = countSequencialNumbers;
    }
}
