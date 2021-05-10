package refactored;

public class ConsecutiveLowercaseLetters {

    int countConsecutiveLowercaseLetters;

    public int lengthConsecutiveLowercaseLetters(String[] candidateArray) {
        Integer nTmpAlphaLC = null;
        for (int i = 0; i < candidateArray.length; i++) {
            if (candidateArray[i].matches("[a-z]")) {
                if (nTmpAlphaLC != null) {
                    if (nTmpAlphaLC + 1 == i) {
                        countConsecutiveLowercaseLetters++;
                    }
                }
                nTmpAlphaLC = i;
            }
        }
        return countConsecutiveLowercaseLetters;
    }
    public int bonusConsecutiveLowercaseLetters() {
        int multiplierConsecutiveUppercaseLetters = 2;
        if (countConsecutiveLowercaseLetters > 0) {
            return countConsecutiveLowercaseLetters * multiplierConsecutiveUppercaseLetters;
        } else {
            return 0;
        }
    }
}