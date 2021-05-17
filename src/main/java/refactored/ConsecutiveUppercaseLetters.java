package refactored;

public class ConsecutiveUppercaseLetters {

    private int bonusConsecutiveUppercaseLetters;
    private int countConsecutiveUppercaseLetters;

    public ConsecutiveUppercaseLetters(String[] candidateArray) {
        this.countLengthConsecutiveUppercaseLetters(candidateArray);
        this.calculateBonusConsecutiveUppercaseLetters();
    }

    public void countLengthConsecutiveUppercaseLetters(String[] candidateArray) {
        Integer nTmpAlphaUC = null;
        for (int i = 0; i < candidateArray.length; i++) {
            if (candidateArray[i].matches("[A-Z]")) {
                if (nTmpAlphaUC != null) {
                    if (nTmpAlphaUC + 1 == i) {
                        countConsecutiveUppercaseLetters++;
                    }
                }
                nTmpAlphaUC = i;
            }
        }
    }
    public void calculateBonusConsecutiveUppercaseLetters() {
        int multiplierConsecutiveUppercaseLetters = 2;
        if (countConsecutiveUppercaseLetters > 0) {
            bonusConsecutiveUppercaseLetters = countConsecutiveUppercaseLetters * multiplierConsecutiveUppercaseLetters;
        } else {
            bonusConsecutiveUppercaseLetters = 0;
        }
    }

    public int getBonusConsecutiveUppercaseLetters() {
        return bonusConsecutiveUppercaseLetters;
    }

    public int getCountConsecutiveUppercaseLetters() {
        return countConsecutiveUppercaseLetters;
    }

    public void setBonusConsecutiveUppercaseLetters(int bonusConsecutiveUppercaseLetters) {
        this.bonusConsecutiveUppercaseLetters = bonusConsecutiveUppercaseLetters;
    }

    public void setCountConsecutiveUppercaseLetters(int countConsecutiveUppercaseLetters) {
        this.countConsecutiveUppercaseLetters = countConsecutiveUppercaseLetters;
    }
}
