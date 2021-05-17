package refactored;

public class LettersOnly {

    private int bonusLettersOnly;
    private int countLettersOnly;

    public LettersOnly(int countLength, int countAlphaLC, int countAlphaUC, int countSymbol, int countNumber) {
        this.countLengthLettersOnly(countLength, countAlphaLC, countAlphaUC, countSymbol, countNumber);
        this.calculateBonusLettersOnly(countLength, countAlphaLC, countAlphaUC, countSymbol, countNumber);
    }

    public void countLengthLettersOnly(int countLength, int countAlphaLC, int countAlphaUC, int countSymbol, int countNumber) {
        if ((countAlphaLC > 0 || countAlphaUC > 0) && countSymbol == 0 && countNumber == 0) {  // Only Letters
            countLettersOnly = countLength;
        }
    }
    public void calculateBonusLettersOnly(int countLength, int countAlphaLC, int countAlphaUC, int countSymbol, int countNumber) {
        if ((countAlphaLC > 0 || countAlphaUC > 0) && countSymbol == 0 && countNumber == 0) {  // Only Letters
            bonusLettersOnly = countLength;
        }
    }

    public int getBonusLetterOnly() {
        return bonusLettersOnly;
    }

    public int getCountLetterOnly() {
        return countLettersOnly;
    }

    public void setBonusLetterOnly(int bonusLetterOnly) {
        this.bonusLettersOnly = bonusLetterOnly;
    }

    public void setCountLetterOnly(int countLetterOnly) {
        this.countLettersOnly = countLetterOnly;
    }
}
