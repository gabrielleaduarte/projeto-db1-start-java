package refactored;

public class ConsecutiveNumber {

    int countConsecutiveNumber;

    public int lengthConsecutiveNumber(String[] candidateArray) {
        Integer nTmpNumber = null;
        for (int i = 0; i < candidateArray.length; i++) {
            if (candidateArray[i].matches("[0-9]")) {
                if (nTmpNumber != null) {
                    if (nTmpNumber + 1 == i) {
                        countConsecutiveNumber++;
                    }
                }
                nTmpNumber = i;
            }
        }
        return countConsecutiveNumber;
    }
    public int bonusConsecutiveLowercaseLetters() {
        int multiplierConsecutiveUppercaseLetters = 2;
        if (countConsecutiveNumber > 0) {
            return countConsecutiveNumber * multiplierConsecutiveUppercaseLetters;
        } else {
            return 0;
        }
    }
}
