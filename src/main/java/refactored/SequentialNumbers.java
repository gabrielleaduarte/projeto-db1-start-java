package refactored;

public class SequentialNumbers {

    private int bonusSequentialNumbers;
    private int countSequentialNumbers;

    public SequentialNumbers(String candidateArray) {
        this.countLengthSequentialNumbers(candidateArray);
        this.calculateBonusSequentialNumbers();
    }

    public void countLengthSequentialNumbers(String candidateArray) {
        for (int i = 0; i < 8; i++) {
            String DIGITS = "01234567890";
            String sFwd = DIGITS.substring(i, i + 3);
            String sRev = new StringBuilder(sFwd).reverse().toString();
            if (candidateArray.toLowerCase().contains(sFwd) || candidateArray.toLowerCase().contains(sRev)) {
                countSequentialNumbers++;
            }
        }
    }

    public void calculateBonusSequentialNumbers() {
        int multiplierConsecutiveUppercaseLetters = 3;
        if (countSequentialNumbers > 0) {
            bonusSequentialNumbers = countSequentialNumbers * multiplierConsecutiveUppercaseLetters;
        } else {
            bonusSequentialNumbers = 0;
        }
    }

    public int getBonusSequentialNumbers() {
        return bonusSequentialNumbers;
    }

    public int getCountSequentialNumbers() {
        return countSequentialNumbers;
    }

    public void setBonusSequentialNumbers(int bonusSequentialNumbers) {
        this.bonusSequentialNumbers = bonusSequentialNumbers;
    }

    public void setCountSequentialNumbers(int countSequentialNumbers) {
        this.countSequentialNumbers = countSequentialNumbers;
    }
}
