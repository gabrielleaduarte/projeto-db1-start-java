package refactored;

public class Requirements {

    int countRequirements;
    public String[] levelsOfMandatoryItems = new String[5];
    int MINIMUM_LENGTH = 8;

    public int lengthRequirements(int countLength, int countAlphaUC, int countAlphaLC, int countNumber, int countSymbol) {
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
        return countRequirements;
    }
    public int bonusRequirements(String candidate){
        int multiplierRequirements = 2;
        int nMinReqChars = candidate.length() >= MINIMUM_LENGTH ? 3 : 4;
        return countRequirements * multiplierRequirements;
    }
}