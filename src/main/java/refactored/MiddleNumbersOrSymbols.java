package refactored;

public class MiddleNumbersOrSymbols {

    int countMiddleNumbersOrSymbols;

    public int lengthMiddleNumbersOrSymbols(String[] candidateArray) {
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
        return countMiddleNumbersOrSymbols;
    }
    public int bonusMiddleNumbersOrSymbols() {
        int multiplierLength = 2;
        return countMiddleNumbersOrSymbols * multiplierLength;
    }
}
