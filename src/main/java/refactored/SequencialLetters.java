package refactored;

public class SequencialLetters {

    int countSequencialLetters;

    public int lengthSequencialLetters(String candidateArray) {
        String ALPHAS = "abcdefghijklmnopqrstuvwxyz";
        int tamanho = ALPHAS.length() - 3;
        for (int i = 0; i < tamanho; i++) {
            String sFwd = ALPHAS.substring(i, i + 3);
            String sRev = new StringBuilder(sFwd).reverse().toString();
            if (candidateArray.toLowerCase().contains(sFwd) || candidateArray.toLowerCase().contains(sRev)) {
                countSequencialLetters++;
            }
        }
        return countSequencialLetters;
    }
    public int bonusSequencialLetters() {
        int multiplierConsecutiveUppercaseLetters = 3;
        if (countSequencialLetters > 0) {
            return countSequencialLetters * multiplierConsecutiveUppercaseLetters;
        } else {
            return 0;
        }
    }
}