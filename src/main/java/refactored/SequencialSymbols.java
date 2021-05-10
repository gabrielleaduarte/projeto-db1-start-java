package refactored;

public class SequencialSymbols {

    int countSequencialSymbols;

    public int lengthSequencialNumbers(String candidateArray) {
        for (int i = 0; i < 8; i++) {
            String SYMBOLS = ")!@#$%^&*()";
            String sFwd = SYMBOLS.substring(i, i + 3);
            String sRev = new StringBuilder(sFwd).reverse().toString();
            if (candidateArray.toLowerCase().contains(sFwd) || candidateArray.toLowerCase().contains(sRev)) {
                countSequencialSymbols++;
            }
        }
        return countSequencialSymbols;
    }
    public int bonusSequencialNumbers() {
        int multiplierConsecutiveUppercaseLetters = 3;
        if (countSequencialSymbols > 0) {
            return countSequencialSymbols * multiplierConsecutiveUppercaseLetters;
        } else {
            return 0;
        }
    }
}
