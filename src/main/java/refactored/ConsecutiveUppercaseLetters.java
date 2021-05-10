package refactored;

public class ConsecutiveUppercaseLetters {

    int countConsecutiveUppercaseLetters;

    public int lengthConsecutiveUppercaseLetters(String[] candidateArray) {
        Integer nTmpAlphaUC = null;
        for (int i = 0; i < candidateArray.length; i++) {
            if (candidateArray[i].matches("[A-Z]")) {
                if (nTmpAlphaUC != null) {
                    if (nTmpAlphaUC + 1 == i) {
                        countConsecutiveUppercaseLetters++;
                    }
                }
                nTmpAlphaUC = i;
            }
        }
        return  countConsecutiveUppercaseLetters;
    }
    public int bonusConsecutiveUppercaseLetters() {
        int multiplierConsecutiveUppercaseLetters = 2;
        if (countConsecutiveUppercaseLetters > 0) {
            return countConsecutiveUppercaseLetters * multiplierConsecutiveUppercaseLetters;
        } else {
            return 0;
        }
    }
}
