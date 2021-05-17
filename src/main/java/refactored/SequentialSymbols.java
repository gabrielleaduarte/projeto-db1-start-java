package refactored;

public class SequentialSymbols {

    private int bonusSequentialSymbols;
    private int countSequentialSymbols;

    public SequentialSymbols(String candidateArray) {
        this.countLengthSequentialNumbers(candidateArray);
        this.calculateBonusSequentialNumbers();
    }

    public void countLengthSequentialNumbers(String candidateArray) {
        for (int i = 0; i < 8; i++) {
            String SYMBOLS = ")!@#$%^&*()";
            String sFwd = SYMBOLS.substring(i, i + 3);
            String sRev = new StringBuilder(sFwd).reverse().toString();
            if (candidateArray.toLowerCase().contains(sFwd) || candidateArray.toLowerCase().contains(sRev)) {
                countSequentialSymbols++;
            }
        }
    }
    public void calculateBonusSequentialNumbers() {
        int multiplierConsecutiveUppercaseLetters = 3;
        if (countSequentialSymbols > 0) {
            bonusSequentialSymbols = countSequentialSymbols * multiplierConsecutiveUppercaseLetters;
        } else {
            bonusSequentialSymbols = 0;
        }
    }

    public int getBonusSequentialSymbols() {
        return bonusSequentialSymbols;
    }

    public int getCountSequentialSymbols() {
        return countSequentialSymbols;
    }

    public void setBonusSequentialSymbols(int bonusSequentialSymbols) {
        this.bonusSequentialSymbols = bonusSequentialSymbols;
    }

    public void setCountSequentialSymbols(int countSequentialSymbols) {
        this.countSequentialSymbols = countSequentialSymbols;
    }
}
