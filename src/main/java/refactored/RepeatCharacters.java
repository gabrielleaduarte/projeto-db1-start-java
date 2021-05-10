package refactored;

public class RepeatCharacters {

    int countRepeatCharacters;
    double incrementDeductionOfRepeatedChars = 0;

    public int lengthRepeatCharacters(String[] candidateArray) {
        var bCharExists = false;
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
        return countRepeatCharacters;
    }
    public int bonusRepeatCharacter() {
        if (countRepeatCharacters > 0){
            return (int) incrementDeductionOfRepeatedChars;
        } else {
            return 0;
        }
    }
}
