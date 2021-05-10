package refactored;

public class Numbers {

    int countNumbers;

    public int lengthNumbers(String[] candidateArray) {
        for (String s : candidateArray) {
            if (s.matches("[0-9]")) {
                countNumbers++;
            }
        }
        return countNumbers;
    }
    public int bonusNumbers(int countLength) {
        int multiplierNumbers = 4;
        if (countNumbers > 0 && countNumbers < countLength) {
            return countNumbers * multiplierNumbers;
        } else {
            return 0;
        }
    }
}
