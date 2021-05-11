package refactored;

public class ConsecutiveLowercaseLetters {

    int bonusConsecutiveLowercaseLetters;
    int countConsecutiveLowercaseLetters;

    public ConsecutiveLowercaseLetters(String[] candidateArray) {
        countLengthConsecutiveLowercaseLetters(candidateArray);
        calculateBonusConsecutiveLowercaseLetters();
    }

    public void countLengthConsecutiveLowercaseLetters(String[] candidateArray) {
        Integer nTmpAlphaLC = null;
        for (int i = 0; i < candidateArray.length; i++) {
            if (candidateArray[i].matches("[a-z]")) {
                if (nTmpAlphaLC != null) {
                    if (nTmpAlphaLC + 1 == i) {
                        countConsecutiveLowercaseLetters++;
                    }
                }
                nTmpAlphaLC = i;
            }
        }
    }

    public void calculateBonusConsecutiveLowercaseLetters() {
        int multiplierConsecutiveUppercaseLetters = 2;
        if (countConsecutiveLowercaseLetters > 0) {
            bonusConsecutiveLowercaseLetters = countConsecutiveLowercaseLetters * multiplierConsecutiveUppercaseLetters;
        } else {
            bonusConsecutiveLowercaseLetters = 0;
        }
    }

    public int getBonusConsecutiveLowercaseLetters() {
        return bonusConsecutiveLowercaseLetters;
    }

    public int getCountConsecutiveLowercaseLetters() {
        return countConsecutiveLowercaseLetters;
    }

    public void setBonusConsecutiveLowercaseLetters(int bonusConsecutiveLowercaseLetters) {
        this.bonusConsecutiveLowercaseLetters = bonusConsecutiveLowercaseLetters;
    }

    public void setCountConsecutiveLowercaseLetters(int countConsecutiveLowercaseLetters) {
        this.countConsecutiveLowercaseLetters = countConsecutiveLowercaseLetters;
    }
}