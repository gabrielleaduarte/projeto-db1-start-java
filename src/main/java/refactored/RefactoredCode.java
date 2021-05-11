package refactored;

public class RefactoredCode {

    public int score;
    public String password;
    public String sComplexity = "Too Short";

    public NumberOfCharacters numberOfCharacters;
    public UppercaseLetters uppercaseLetters;
    public LowercaseLetters lowercaseLetters;

    public int bonusNumber, countNumber;
    public Numbers numbers = new Numbers();

    public int bonusSymbol, countSymbol;
    public Symbols symbols = new Symbols();

    public int bonusMidChar, countMidChar;
    public MiddleNumbersOrSymbols middleNumbersOrSymbols = new MiddleNumbersOrSymbols();

    public int bonusRequirements, countRequirements;
    public Requirements requirements = new Requirements();

    public int bonusAlphasOnly, countAlphasOnly;
    public LettersOnly lettersOnly = new LettersOnly();

    public int bonusNumbersOnly, countNumbersOnly;
    public NumbersOnly numbersOnly = new NumbersOnly();

    public int bonusRepChar, countRepChar;
    public RepeatCharacters repeatCharacters = new RepeatCharacters();

    public int bonusConsecutiveAlphaUC, countConsecutiveAlphaUC;
    public ConsecutiveUppercaseLetters consecutiveUppercaseLetters = new ConsecutiveUppercaseLetters();

    public int bonusConsecutiveAlphaLC, countConsecutiveAlphaLC;
    public ConsecutiveLowercaseLetters consecutiveLowercaseLetters = new ConsecutiveLowercaseLetters();

    public int bonusConsecutiveNumber, countConsecutiveNumber;
    public ConsecutiveNumber consecutiveNumber = new ConsecutiveNumber();

    public int bonusSeqNumber, countSeqNumber;
    public SequencialLetters sequencialLetters = new SequencialLetters();

    public int bonusSeqSymbol, countSeqSymbol;
    public SequencialNumbers sequencialNumbers = new SequencialNumbers();

    public int bonusSeqAlpha, countSeqAlpha;
    public SequencialSymbols sequencialSymbols = new SequencialSymbols();

    public String[] levelsOfBonusItems = new String[2];
    public String[] levelsOfSuggestedItems = new String[9];

    public void checkPassword(String candidate) {
        password = candidate;
        String[] arrPwd = candidate.replaceAll("\\s+", "").split("\\s*");

        numberOfCharacters = new NumberOfCharacters(candidate);
        int countLength = numberOfCharacters.getCountLength();

        uppercaseLetters = new UppercaseLetters(arrPwd,countLength);
        int countAlphaUC = uppercaseLetters.getCountUppercaseLetters();

        lowercaseLetters = new LowercaseLetters(arrPwd, countLength);
        int countAlphaLC = lowercaseLetters.getCountLowercaseLetters();


        countNumber = numbers.lengthNumbers(arrPwd);
        bonusNumber = numbers.bonusNumbers(countLength);

        countSymbol = symbols.lengthSymbols(arrPwd);
        bonusSymbol = symbols.bonusSymbols();

        countMidChar = middleNumbersOrSymbols.lengthMiddleNumbersOrSymbols(arrPwd);
        bonusMidChar = middleNumbersOrSymbols.bonusMiddleNumbersOrSymbols();

        countRequirements = requirements.lengthRequirements(countLength, countAlphaUC, countAlphaLC, countNumber, countSymbol);
        bonusRequirements = requirements.bonusRequirements(candidate);

        countRepChar = repeatCharacters.lengthRepeatCharacters(arrPwd);
        bonusRepChar = repeatCharacters.bonusRepeatCharacter();

        countConsecutiveAlphaUC = consecutiveUppercaseLetters.lengthConsecutiveUppercaseLetters(arrPwd);
        bonusConsecutiveAlphaUC = consecutiveUppercaseLetters.bonusConsecutiveUppercaseLetters();

        countConsecutiveAlphaLC = consecutiveLowercaseLetters.lengthConsecutiveLowercaseLetters(arrPwd);
        bonusConsecutiveAlphaLC = consecutiveLowercaseLetters.bonusConsecutiveLowercaseLetters();

        countConsecutiveNumber = consecutiveNumber.lengthConsecutiveNumber(arrPwd);
        bonusConsecutiveNumber = consecutiveNumber.bonusConsecutiveLowercaseLetters();

        countSeqAlpha = sequencialLetters.lengthSequencialLetters(candidate);
        bonusSeqAlpha = sequencialLetters.bonusSequencialLetters();

        countSeqNumber = sequencialNumbers.lengthSequencialNumbers(candidate);
        bonusSeqNumber = sequencialNumbers.bonusSequencialNumbers();

        countSeqSymbol = sequencialSymbols.lengthSequencialNumbers(candidate);
        bonusSeqSymbol = sequencialSymbols.bonusSequencialNumbers();

        if ((countAlphaLC > 0 || countAlphaUC > 0) && countSymbol == 0 && countNumber == 0) {  // Only Letters
            countAlphasOnly = lettersOnly.countLengthLettersOnly(countLength);
            bonusAlphasOnly = lettersOnly.calculateBonusLetterOnly(countLength);
        }
        if (countAlphaLC == 0 && countAlphaUC == 0 && countSymbol == 0 && countNumber > 0) {  // Only Numbers
            countNumbersOnly = numbersOnly.lengthNumbersOnly(countLength);
            bonusNumbersOnly = numbersOnly.bonusNumbersOnly(countLength);
        }


        /* Determine if mandatory requirements have been met and set image indicators accordingly */
        int[] arrChars = {countLength, countAlphaUC, countAlphaLC, countNumber, countSymbol};
        String[] arrCharsIds = {"countLength", "countAlphaUC", "countAlphaLC", "countNumber", "countSymbol"};
        var arrCharsLen = arrChars.length;
        int MINIMUM_LENGTH = 8;
        int nMinReqChars = candidate.length() >= MINIMUM_LENGTH ? 3 : 4;


        /* Determine if additional bonuses need to be applied and set image indicators accordingly */
        arrChars = new int[]{countMidChar, countRequirements};
        arrCharsIds = new String[]{"countMidChar", "countRequirements"};
        arrCharsLen = arrChars.length;
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

        /* Determine if suggested requirements have been met and set image indicators accordingly */
        arrChars = new int[]{countAlphasOnly, countNumbersOnly, countRepChar, countConsecutiveAlphaUC,
                countConsecutiveAlphaLC, countConsecutiveNumber, countSeqAlpha, countSeqNumber, countSeqSymbol};
        arrCharsLen = arrChars.length;
        for (var c = 0; c < arrCharsLen; c++) {
            levelsOfSuggestedItems[c] = arrChars[c] > 0 ? "warning" : "sufficient";
        }

        /* Determine complexity based on overall score */
        if (score > 100) {
            score = 100;
        } else if (score < 0) {
            score = 0;
        }

        if (score < 20) {
            sComplexity = "Very Weak";
        } else if (score < 40) {
            sComplexity = "Weak";
        } else if (score < 60) {
            sComplexity = "Good";
        } else if (score < 80) {
            sComplexity = "Strong";
        } else {
            sComplexity = "Very Strong";
        }
    }

    @Override
    public String toString() {
        return "Password: " + password
                + "\nScore: " + score
                + "\nComplexity: " + sComplexity

                + "\nAddictions"
                + "\n[C: " + numberOfCharacters.getCountLength() + " | B: " + numberOfCharacters.getBonusLength() + "] Number of Characters"
                + "\n[C: " + uppercaseLetters.getCountUppercaseLetters() + " | B: " + uppercaseLetters.getBonusUCLetters() + "] Uppercase Letters"
                + "\n[C: " + lowercaseLetters.getCountLowercaseLetters() + " | B: " + lowercaseLetters.getBonusLowercaseLetters() + "] Lowercase Letters"
                + "\n[C: " + countNumber + " | B: " + bonusNumber + "] Numbers"
                + "\n[C: " + countSymbol + " | B: " + bonusSymbol + "] Symbols"
                + "\n[C: " + countMidChar + " | B: " + bonusMidChar + "] Middle Numbers or Symbols"
                + "\n[C: " + countRequirements + " | B: " + bonusRequirements + "] Requirements"

                + "\nDeductions"
                + "\n[C: " + countAlphasOnly + " | B: " + bonusAlphasOnly + "] Letters Only"
                + "\n[C: " + countNumbersOnly + " | B: " + bonusNumbersOnly + "] Numbers Only"
                + "\n[C: " + countRepChar + " | B: " + bonusRepChar + "] Repeat Characters (Case Insensitive)"
                + "\n[C: " + countConsecutiveAlphaUC + " | B: " + bonusConsecutiveAlphaUC + "] Consecutive Uppercase Letters"
                + "\n[C: " + countConsecutiveAlphaLC + " | B: " + bonusConsecutiveAlphaLC + "] Consecutive Lowercase Letters"
                + "\n[C: " + countConsecutiveNumber + " | B: " + bonusConsecutiveNumber + "] Consecutive Numbers"
                + "\n[C: " + countSeqAlpha + " | B: " + bonusSeqAlpha + "] Sequential Letters"
                + "\n[C: " + countSeqNumber + " | B: " + bonusSeqNumber + "] Sequential Numbers"
                + "\n[C: " + countSeqSymbol + " | B: " + bonusSeqSymbol + "] Sequential Symbols";
    }
}
