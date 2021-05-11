package refactored;

public class MiddleNumbersOrSymbols {

    int bonusMiddleNumberOrSymbols;
    int countMiddleNumbersOrSymbols;

    public MiddleNumbersOrSymbols(String[] candidateArray) {
        countLengthMiddleNumbersOrSymbols(candidateArray);
        calculateBonusMiddleNumbersOrSymbols();
    }

    public void countLengthMiddleNumbersOrSymbols(String[] candidateArray) {
        for (int i = 0; i < candidateArray.length; i++) {
            if (candidateArray[i].matches("[0-9]")) {
                if (i > 0 && i < candidateArray.length - 1) {
                    countMiddleNumbersOrSymbols++;
                }
            } else if (candidateArray[i].matches("[^a-zA-Z0-9_]")) {
                if (i > 0 && i < candidateArray.length - 1) {
                    countMiddleNumbersOrSymbols++;
                }
            }
        }
    }

    public void calculateBonusMiddleNumbersOrSymbols() {
        int multiplierLength = 2;
        bonusMiddleNumberOrSymbols = countMiddleNumbersOrSymbols * multiplierLength;
    }

    public int getBonusMiddleNumberOrSymbols() {
        return bonusMiddleNumberOrSymbols;
    }

    public int getCountMiddleNumbersOrSymbols() {
        return countMiddleNumbersOrSymbols;
    }

    public void setBonusMiddleNumberOrSymbols(int bonusMiddleNumberOrSymbols) {
        this.bonusMiddleNumberOrSymbols = bonusMiddleNumberOrSymbols;
    }

    public void setCountMiddleNumbersOrSymbols(int countMiddleNumbersOrSymbols) {
        this.countMiddleNumbersOrSymbols = countMiddleNumbersOrSymbols;
    }
}
