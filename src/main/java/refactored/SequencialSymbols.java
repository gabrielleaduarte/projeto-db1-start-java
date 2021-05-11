package refactored;

public class SequencialSymbols {

    int bonusSequencialSymbols;
    int countSequencialSymbols;

    public SequencialSymbols(String candidateArray) {
        countLengthSequencialNumbers(candidateArray);
        calculateBonusSequencialNumbers();
    }

    public void countLengthSequencialNumbers(String candidateArray) {
        for (int i = 0; i < 8; i++) {
            String SYMBOLS = ")!@#$%^&*()";
            String sFwd = SYMBOLS.substring(i, i + 3);
            String sRev = new StringBuilder(sFwd).reverse().toString();
            if (candidateArray.toLowerCase().contains(sFwd) || candidateArray.toLowerCase().contains(sRev)) {
                countSequencialSymbols++;
            }
        }
    }
    public void calculateBonusSequencialNumbers() {
        int multiplierConsecutiveUppercaseLetters = 3;
        if (countSequencialSymbols > 0) {
            bonusSequencialSymbols = countSequencialSymbols * multiplierConsecutiveUppercaseLetters;
        } else {
            bonusSequencialSymbols = 0;
        }
    }

    public int getBonusSequencialSymbols() {
        return bonusSequencialSymbols;
    }

    public int getCountSequencialSymbols() {
        return countSequencialSymbols;
    }

    public void setBonusSequencialSymbols(int bonusSequencialSymbols) {
        this.bonusSequencialSymbols = bonusSequencialSymbols;
    }

    public void setCountSequencialSymbols(int countSequencialSymbols) {
        this.countSequencialSymbols = countSequencialSymbols;
    }
}
