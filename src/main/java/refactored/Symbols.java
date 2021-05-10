package refactored;

public class Symbols {

    int countSymbols;

    public int lengthSymbols(String[] candidateArray) {
        for (String s : candidateArray) {
            if (s.matches("[^a-zA-Z0-9_]")) {
                countSymbols++;
            }
        }
        return countSymbols;
    }
    public int bonusSymbols() {
        int multiplierNumbers = 6;
        if (countSymbols > 0) {
            return countSymbols * multiplierNumbers;
        } else {
            return 0;
        }
    }
}
