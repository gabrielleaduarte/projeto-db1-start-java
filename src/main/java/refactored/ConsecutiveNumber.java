package refactored;

public class ConsecutiveNumber {

    private int bonusConsecutiveNumber;
    private int countConsecutiveNumber;

    public ConsecutiveNumber(String[] candidateArray) {
        this.countLengthConsecutiveNumber(candidateArray);
        this.calculateBonusConsecutiveLowercaseLetters();
    }

    public void countLengthConsecutiveNumber(String[] candidateArray) {
        Integer nTmpNumber = null;
        for (int i = 0; i < candidateArray.length; i++) {
            if (candidateArray[i].matches("[0-9]")) {
                if (nTmpNumber != null) {
                    if (nTmpNumber + 1 == i) {
                        countConsecutiveNumber++;
                    }
                }
                nTmpNumber = i;
            }
        }
    }

    public void calculateBonusConsecutiveLowercaseLetters() {
        int multiplierConsecutiveUppercaseLetters = 2;
        if (countConsecutiveNumber > 0) {
            bonusConsecutiveNumber = countConsecutiveNumber * multiplierConsecutiveUppercaseLetters;
        } else {
            bonusConsecutiveNumber = 0;
        }
    }

    public int getBonusConsecutiveNumber() {
        return bonusConsecutiveNumber;
    }

    public int getCountConsecutiveNumber() {
        return countConsecutiveNumber;
    }

    public void setBonusConsecutiveNumber(int bonusConsecutiveNumber) {
        this.bonusConsecutiveNumber = bonusConsecutiveNumber;
    }

    public void setCountConsecutiveNumber(int countConsecutiveNumber) {
        this.countConsecutiveNumber = countConsecutiveNumber;
    }
}
