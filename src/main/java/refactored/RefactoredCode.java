package refactored;

public class RefactoredCode {

    public int score;
    public String password;
    public String sComplexity = "Too Short";

    public NumberOfCharacters numberOfCharacters;
    public UppercaseLetters uppercaseLetters;
    public LowercaseLetters lowercaseLetters;
    public Numbers numbers;
    public Symbols symbols;
    public MiddleNumbersOrSymbols middleNumbersOrSymbols;
    public Requirements requirements;
    public LettersOnly lettersOnly;
    public NumbersOnly numbersOnly;
    public RepeatCharacters repeatCharacters;
    public ConsecutiveUppercaseLetters consecutiveUppercaseLetters;
    public ConsecutiveLowercaseLetters consecutiveLowercaseLetters;
    public ConsecutiveNumber consecutiveNumber;
    public SequencialLetters sequencialLetters;
    public SequencialNumbers sequencialNumbers;
    public SequencialSymbols sequencialSymbols;


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

        numbers = new Numbers(arrPwd, countLength);
        int countNumber = numbers.getCountNumbers();

        symbols = new Symbols(arrPwd);
        int countSymbol = symbols.getCountSymbols();

        middleNumbersOrSymbols = new MiddleNumbersOrSymbols(arrPwd);
        int countMidChar = symbols.getCountSymbols();

        requirements = new Requirements(countLength, countAlphaUC, countAlphaLC, countNumber, countSymbol, candidate);
        int countRequirements = requirements.getCountRequirements();

        lettersOnly = new LettersOnly(countLength, countAlphaLC, countAlphaUC, countSymbol, countNumber);
        int countAlphasOnly = lettersOnly.getCountLetterOnly();

        numbersOnly = new NumbersOnly(countLength, countAlphaLC, countAlphaUC, countSymbol, countNumber);
        int countNumbersOnly = numbersOnly.getCountNumbersOnly();

        repeatCharacters = new RepeatCharacters(arrPwd);
        int countRepChar = repeatCharacters.getCountRepeatCharacters();

        consecutiveUppercaseLetters = new ConsecutiveUppercaseLetters(arrPwd);
        int countConsecutiveAlphaUC = consecutiveUppercaseLetters.getCountConsecutiveUppercaseLetters();

        consecutiveLowercaseLetters = new ConsecutiveLowercaseLetters(arrPwd);
        int countConsecutiveAlphaLC = consecutiveLowercaseLetters.getCountConsecutiveLowercaseLetters();

        consecutiveNumber = new ConsecutiveNumber(arrPwd);
        int countConsecutiveNumber = consecutiveNumber.getCountConsecutiveNumber();

        sequencialLetters = new SequencialLetters(candidate);
        int countSeqAlpha = sequencialLetters.getCountSequencialLetters();

        sequencialNumbers = new SequencialNumbers(candidate);
        int countSeqNumber = sequencialNumbers.getCountSequencialNumbers();

        sequencialSymbols = new SequencialSymbols(candidate);
        int countSeqSymbol = sequencialSymbols.getCountSequencialSymbols();


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
                + "\n[C: " + numbers.getCountNumbers() + " | B: " + numbers.getBonusNumbers() + "] Numbers"
                + "\n[C: " + symbols.getCountSymbols() + " | B: " + symbols.getBonusSymbols() + "] Symbols"
                + "\n[C: " + middleNumbersOrSymbols.getCountMiddleNumbersOrSymbols() + " | B: " + middleNumbersOrSymbols.getBonusMiddleNumberOrSymbols() + "] Middle Numbers or Symbols"
                + "\n[C: " + requirements.getCountRequirements() + " | B: " + requirements.getBonusRequirements() + "] Requirements"

                + "\nDeductions"
                + "\n[C: " + lettersOnly.getCountLetterOnly() + " | B: " + lettersOnly.getBonusLetterOnly() + "] Letters Only"
                + "\n[C: " + numbersOnly.getCountNumbersOnly() + " | B: " + numbersOnly.getBonusNumbersOnly() + "] Numbers Only"
                + "\n[C: " + repeatCharacters.getCountRepeatCharacters() + " | B: " + repeatCharacters.getBonusRepeatCharacters() + "] Repeat Characters (Case Insensitive)"
                + "\n[C: " + consecutiveUppercaseLetters.getCountConsecutiveUppercaseLetters() + " | B: " + consecutiveUppercaseLetters.getBonusConsecutiveUppercaseLetters() + "] Consecutive Uppercase Letters"
                + "\n[C: " + consecutiveLowercaseLetters.getCountConsecutiveLowercaseLetters() + " | B: " + consecutiveLowercaseLetters.getBonusConsecutiveLowercaseLetters() + "] Consecutive Lowercase Letters"
                + "\n[C: " + consecutiveNumber.getCountConsecutiveNumber() + " | B: " + consecutiveNumber.getBonusConsecutiveNumber() + "] Consecutive Numbers"
                + "\n[C: " + sequencialLetters.getCountSequencialLetters() + " | B: " + sequencialLetters.getBonusSequencialLetters() + "] Sequential Letters"
                + "\n[C: " + sequencialNumbers.getCountSequencialNumbers() + " | B: " + sequencialNumbers.getBonusSequencialNumbers() + "] Sequential Numbers"
                + "\n[C: " + sequencialSymbols.getCountSequencialSymbols() + " | B: " + sequencialSymbols.getBonusSequencialSymbols() + "] Sequential Symbols";
    }
}
