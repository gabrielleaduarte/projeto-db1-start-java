package refactored;

public class RepeatCharacters {

    private int bonusRepeatCharacters;
    private int countRepeatCharacters;
    private double incrementDeductionOfRepeatedChars = 0;

    public RepeatCharacters(String[] candidateArray) {
        this.countLengthRepeatCharacters(candidateArray);
        this.calculateBonusRepeatCharacter();
    }

    public void countLengthRepeatCharacters(String[] candidateArray) {
        boolean bCharExists = false;
        for (int i = 0; i < candidateArray.length; i++) {
            for (int j = 0; j < candidateArray.length; j++) {
                if (candidateArray[i].equals(candidateArray[j]) && i != j) {
                    bCharExists = true;
                    incrementDeductionOfRepeatedChars += Math.abs(candidateArray.length / (j - i));
                }
            }
            if (bCharExists) {
                countRepeatCharacters++;
                int countUniqueCharacters = candidateArray.length - countRepeatCharacters;
                incrementDeductionOfRepeatedChars = countUniqueCharacters != 0 ?
                        Math.ceil(incrementDeductionOfRepeatedChars / countUniqueCharacters) :
                        Math.ceil(incrementDeductionOfRepeatedChars);
            }
        }
    }

    public void calculateBonusRepeatCharacter() {
        if (countRepeatCharacters > 0){
            bonusRepeatCharacters = (int) incrementDeductionOfRepeatedChars;
        } else {
            bonusRepeatCharacters = 0;
        }
    }

    public int getBonusRepeatCharacters() {
        return bonusRepeatCharacters;
    }

    public int getCountRepeatCharacters() {
        return countRepeatCharacters;
    }

    public void setBonusRepeatCharacters(int bonusRepeatCharacters) {
        this.bonusRepeatCharacters = bonusRepeatCharacters;
    }

    public void setCountRepeatCharacters(int countRepeatCharacters) {
        this.countRepeatCharacters = countRepeatCharacters;
    }
}
