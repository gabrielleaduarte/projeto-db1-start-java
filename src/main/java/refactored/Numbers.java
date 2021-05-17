package refactored;

public class Numbers {

    private int bonusNumbers;
    private int countNumbers;

    public Numbers(String[] candidateArray, int countLength) {
        this.countLengthNumbers(candidateArray);
        this.calculateBonusNumbers(countLength);
    }

    public void countLengthNumbers(String[] candidateArray) {
        for (String s : candidateArray) {
            if (s.matches("[0-9]")) {
                countNumbers++;
            }
        }
    }

    public void calculateBonusNumbers(int countLength) {
        int multiplierNumbers = 4;
        if (countNumbers > 0 && countNumbers < countLength) {
            bonusNumbers =  countNumbers * multiplierNumbers;
        } else {
            bonusNumbers = 0;
        }
    }

    public int getBonusNumbers() {
        return bonusNumbers;
    }

    public int getCountNumbers() {
        return countNumbers;
    }

    public void setBonusNumbers(int bonusNumbers) {
        this.bonusNumbers = bonusNumbers;
    }

    public void setCountNumbers(int countNumbers) {
        this.countNumbers = countNumbers;
    }
}
