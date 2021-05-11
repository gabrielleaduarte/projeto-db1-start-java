package refactored;

public class Requirements {

    int bonusRequirements;
    int countRequirements;
    public String[] levelsOfMandatoryItems = new String[5];
    int MINIMUM_LENGTH = 8;

    public Requirements(int countLength, int countAlphaUC, int countAlphaLC, int countNumber, int countSymbol, String candidate) {
        countLengthRequirements(countLength, countAlphaUC, countAlphaLC, countNumber, countSymbol);
        calculateBonusRequirements(candidate);
    }

    public void countLengthRequirements(int countLength, int countAlphaUC, int countAlphaLC, int countNumber, int countSymbol) {
        int[] arrChars = {countLength, countAlphaUC, countAlphaLC, countNumber, countSymbol};
        String[] arrCharsIds = {"countLength", "countAlphaUC", "countAlphaLC", "countNumber", "countSymbol"};
        var arrCharsLen = arrChars.length;
        for (int i = 0; i < arrCharsLen; i++) {
            int minVal = arrCharsIds[i].equals("countLength") ? MINIMUM_LENGTH - 1 : 0;
            if (arrChars[i] == minVal + 1) {
                countRequirements++;
                levelsOfMandatoryItems[i] = "sufficient";
            } else if (arrChars[i] > minVal + 1) {
                countRequirements++;
                levelsOfMandatoryItems[i] = "exceptional";
            } else {
                levelsOfMandatoryItems[i] = "failure";
            }
        }
    }
    public void calculateBonusRequirements(String candidate){
        int multiplierRequirements = 2;
        int nMinReqChars = candidate.length() >= MINIMUM_LENGTH ? 3 : 4;
        bonusRequirements = countRequirements * multiplierRequirements;
    }

    public int getBonusRequirements() {
        return bonusRequirements;
    }

    public int getCountRequirements() {
        return countRequirements;
    }

    public void setBonusRequirements(int bonusRequirements) {
        this.bonusRequirements = bonusRequirements;
    }

    public void setCountRequirements(int countRequirements) {
        this.countRequirements = countRequirements;
    }
}