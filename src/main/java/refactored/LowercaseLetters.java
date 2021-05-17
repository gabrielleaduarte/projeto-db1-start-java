package refactored;

public class LowercaseLetters {

    private int bonusLowercaseLetters;
    private int countLowercaseLetters;

    public LowercaseLetters(String[] candidateArray, int countLength) {
        this.countLengthLowercaseLetters(candidateArray);
        this.calculateBonusLowercaseLetters(countLength);
    }

    public void countLengthLowercaseLetters(String[] candidateArray) {
        for (String s : candidateArray) {
            if (s.matches("[a-z]")) {
                countLowercaseLetters++;
            }
        }
    }
    public void calculateBonusLowercaseLetters(int countLength) {
        int multiplierLowercaseLetters = 2;
        if (countLowercaseLetters > 0 && countLowercaseLetters < countLength) {
            bonusLowercaseLetters = (countLength - countLowercaseLetters) * multiplierLowercaseLetters;
        } else {
            bonusLowercaseLetters = 0;
        }
    }

    public int getBonusLowercaseLetters() {
        return bonusLowercaseLetters;
    }

    public int getCountLowercaseLetters() {
        return countLowercaseLetters;
    }

    public void setBonusLowercaseLetters(int bonusLowercaseLetters) {
        this.bonusLowercaseLetters = bonusLowercaseLetters;
    }

    public void setCountLowercaseLetters(int countLowercaseLetters) {
        this.countLowercaseLetters = countLowercaseLetters;
    }
}
