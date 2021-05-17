package refactored;

public class Symbols {

    private int bonusSymbols;
    private int countSymbols;

    public Symbols(String[] candidateAray) {
        this.countLengthSymbols(candidateAray);
        this.calculateBonusSymbols();
    }

    public void countLengthSymbols(String[] candidateArray) {
        for (String s : candidateArray) {
            if (s.matches("[^a-zA-Z0-9_]")) {
                countSymbols++;
            }
        }
    }
    public void calculateBonusSymbols() {
        int multiplierNumbers = 6;
        if (countSymbols > 0) {
            bonusSymbols = countSymbols * multiplierNumbers;
        } else {
            bonusSymbols = 0;
        }
    }

    public int getBonusSymbols() {
        return bonusSymbols;
    }

    public int getCountSymbols() {
        return countSymbols;
    }

    public void setBonusSymbols(int bonusSymbols) {
        this.bonusSymbols = bonusSymbols;
    }

    public void setCountSymbols(int countSymbols) {
        this.countSymbols = countSymbols;
    }
}
