package refactored;

public class RequirementsEvaluation {

    private int nMinReqChars;
    private String[] levelsOfBonusItems = new String[2];
    private String[] levelsOfSuggestedItems = new String[9];

    public RequirementsEvaluation(int countLength, int countAlphaUC, int countAlphaLC, int countNumber, int countSymbol,
                                  String candidate, int countMidChar, int countRequirements, int countAlphasOnly,
                                  int countNumbersOnly, int countRepChar, int countConsecutiveAlphaUC, int countConsecutiveAlphaLC,
                                  int countConsecutiveNumber, int countSeqAlpha, int countSeqNumber, int countSeqSymbol){
        this.determineMandatoryRequirements(countLength, countAlphaUC, countAlphaLC, countNumber, countSymbol, candidate);
        this.determineAdditionalBonuses(countMidChar, countRequirements);
        this.determineSuggestedRequirements(countAlphasOnly, countNumbersOnly, countRepChar, countConsecutiveAlphaUC,
                countConsecutiveAlphaLC, countConsecutiveNumber, countSeqAlpha, countSeqNumber, countSeqSymbol);
    }

    public void determineMandatoryRequirements(int countLength, int countAlphaUC, int countAlphaLC, int countNumber, int countSymbol, String candidate) {
        int[] arrChars = {countLength, countAlphaUC, countAlphaLC, countNumber, countSymbol};
        String[] arrCharsIds = {"countLength", "countAlphaUC", "countAlphaLC", "countNumber", "countSymbol"};
        var arrCharsLen = arrChars.length;
        int MINIMUM_LENGTH = 8;
        nMinReqChars = candidate.length() >= MINIMUM_LENGTH ? 3 : 4;
    }

    public void determineAdditionalBonuses(int countMidChar, int countRequirements) {
        int [] arrChars = new int[]{countMidChar, countRequirements};
        String[] arrCharsIds = new String[]{"countMidChar", "countRequirements"};
        var arrCharsLen = arrChars.length;
        for (var c = 0; c < arrCharsLen; c++) {
            int minVal = arrCharsIds[c].equals("countRequirements") ? nMinReqChars : 0;
            if (arrChars[c] == minVal + 1) {
                levelsOfBonusItems[c] = "sufficient";
            } else if (arrChars[c] > minVal + 1) {
                levelsOfBonusItems[c] = "exceptional";
            } else {
                levelsOfBonusItems[c] = "failure";
            }
        }
    }

    public void determineSuggestedRequirements(int countAlphasOnly, int countNumbersOnly, int countRepChar, int countConsecutiveAlphaUC,
                                               int countConsecutiveAlphaLC, int countConsecutiveNumber, int countSeqAlpha,
                                               int countSeqNumber, int countSeqSymbol) {
        int [] arrChars = new int[]{countAlphasOnly, countNumbersOnly, countRepChar, countConsecutiveAlphaUC,
                countConsecutiveAlphaLC, countConsecutiveNumber, countSeqAlpha, countSeqNumber, countSeqSymbol};
        var arrCharsLen = arrChars.length;
        for (var c = 0; c < arrCharsLen; c++) {
            levelsOfSuggestedItems[c] = arrChars[c] > 0 ? "warning" : "sufficient";
        }
    }

    public int getnMinReqChars() {
        return nMinReqChars;
    }

    public String[] getLevelsOfBonusItems() {
        return levelsOfBonusItems;
    }

    public String[] getLevelsOfSuggestedItems() {
        return levelsOfSuggestedItems;
    }

    public void setnMinReqChars(int nMinReqChars) {
        this.nMinReqChars = nMinReqChars;
    }

    public void setLevelsOfBonusItems(String[] levelsOfBonusItems) {
        this.levelsOfBonusItems = levelsOfBonusItems;
    }

    public void setLevelsOfSuggestedItems(String[] levelsOfSuggestedItems) {
        this.levelsOfSuggestedItems = levelsOfSuggestedItems;
    }
}

