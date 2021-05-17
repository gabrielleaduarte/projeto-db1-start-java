package refactored;

public class SequentialLetters {

    private int bonusSequentialLetters;
    private int countSequentialLetters;

    public SequentialLetters(String candidateArray) {
        this.countLengthSequentialLetters(candidateArray);
        this.calculateBonusSequentialLetters();
    }

    public void countLengthSequentialLetters(String candidateArray) {
        String ALPHAS = "abcdefghijklmnopqrstuvwxyz";
        int size = ALPHAS.length() - 3;
        for (int i = 0; i < size; i++) {
            String sFwd = ALPHAS.substring(i, i + 3);
            String sRev = new StringBuilder(sFwd).reverse().toString();
            if (candidateArray.toLowerCase().contains(sFwd) || candidateArray.toLowerCase().contains(sRev)) {
                countSequentialLetters++;
            }
        }
    }

    public void calculateBonusSequentialLetters() {
        int multiplierConsecutiveUppercaseLetters = 3;
        if (countSequentialLetters > 0) {
            bonusSequentialLetters = countSequentialLetters * multiplierConsecutiveUppercaseLetters;
        } else {
            bonusSequentialLetters = 0;
        }
    }

    public int getBonusSequentialLetters() {
        return bonusSequentialLetters;
    }

    public int getCountSequentialLetters() {
        return countSequentialLetters;
    }

    public void setBonusSequentialLetters(int bonusSequentialLetters) {
        this.bonusSequentialLetters = bonusSequentialLetters;
    }

    public void setCountSequentialLetters(int countSequentialLetters) {
        this.countSequentialLetters = countSequentialLetters;
    }
}