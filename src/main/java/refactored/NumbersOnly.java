package refactored;

public class NumbersOnly {

    int bonusNumbersOnly;
    int countNumbersOnly;

    public NumbersOnly(int countLength, int countAlphaLC, int countAlphaUC, int countSymbol, int countNumber) {
        countLengthNumbersOnly(countLength, countAlphaLC, countAlphaUC, countSymbol, countNumber);
        calculateBonusNumbersOnly(countLength, countAlphaLC, countAlphaUC, countSymbol, countNumber);
    }

    public void countLengthNumbersOnly(int countLength, int countAlphaLC, int countAlphaUC, int countSymbol, int countNumber) {
        if (countAlphaLC == 0 && countAlphaUC == 0 && countSymbol == 0 && countNumber > 0) {
            countNumbersOnly = countLength;
        }
    }
    public void calculateBonusNumbersOnly(int countLength, int countAlphaLC, int countAlphaUC, int countSymbol, int countNumber) {
        if (countAlphaLC == 0 && countAlphaUC == 0 && countSymbol == 0 && countNumber > 0) {
            bonusNumbersOnly = countLength;
        }
    }

    public int getBonusNumbersOnly() {
        return bonusNumbersOnly;
    }

    public int getCountNumbersOnly() {
        return countNumbersOnly;
    }

    public void setBonusNumbersOnly(int bonusNumbersOnly) {
        this.bonusNumbersOnly = bonusNumbersOnly;
    }

    public void setCountNumbersOnly(int countNumbersOnly) {
        this.countNumbersOnly = countNumbersOnly;
    }
}
