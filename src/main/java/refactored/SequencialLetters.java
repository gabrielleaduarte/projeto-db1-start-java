package refactored;

public class SequencialLetters {

    int bonusSequencialLetters;
    int countSequencialLetters;

    public SequencialLetters(String candidateArray) {
        countLengthSequencialLetters(candidateArray);
        calculateBonusSequencialLetters();
    }

    public void countLengthSequencialLetters(String candidateArray) {
        String ALPHAS = "abcdefghijklmnopqrstuvwxyz";
        int size = ALPHAS.length() - 3;
        for (int i = 0; i < size; i++) {
            String sFwd = ALPHAS.substring(i, i + 3);
            String sRev = new StringBuilder(sFwd).reverse().toString();
            if (candidateArray.toLowerCase().contains(sFwd) || candidateArray.toLowerCase().contains(sRev)) {
                countSequencialLetters++;
            }
        }
    }

    public void calculateBonusSequencialLetters() {
        int multiplierConsecutiveUppercaseLetters = 3;
        if (countSequencialLetters > 0) {
            bonusSequencialLetters = countSequencialLetters * multiplierConsecutiveUppercaseLetters;
        } else {
            bonusSequencialLetters = 0;
        }
    }

    public int getBonusSequencialLetters() {
        return bonusSequencialLetters;
    }

    public int getCountSequencialLetters() {
        return countSequencialLetters;
    }

    public void setBonusSequencialLetters(int bonusSequencialLetters) {
        this.bonusSequencialLetters = bonusSequencialLetters;
    }

    public void setCountSequencialLetters(int countSequencialLetters) {
        this.countSequencialLetters = countSequencialLetters;
    }
}