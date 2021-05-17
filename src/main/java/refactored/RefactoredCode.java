package refactored;

public class RefactoredCode {

    public String password;
    public Score score;

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
    public SequentialLetters sequentialLetters;
    public SequentialNumbers sequentialNumbers;
    public SequentialSymbols sequentialSymbols;


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
        requirements = new Requirements(countLength, countAlphaUC, countAlphaLC, countNumber, countSymbol, candidate);
        lettersOnly = new LettersOnly(countLength, countAlphaLC, countAlphaUC, countSymbol, countNumber);
        numbersOnly = new NumbersOnly(countLength, countAlphaLC, countAlphaUC, countSymbol, countNumber);
        repeatCharacters = new RepeatCharacters(arrPwd);
        consecutiveUppercaseLetters = new ConsecutiveUppercaseLetters(arrPwd);
        consecutiveLowercaseLetters = new ConsecutiveLowercaseLetters(arrPwd);
        consecutiveNumber = new ConsecutiveNumber(arrPwd);
        sequentialLetters = new SequentialLetters(candidate);
        sequentialNumbers = new SequentialNumbers(candidate);
        sequentialSymbols = new SequentialSymbols(candidate);

        score = new Score(numberOfCharacters.getBonusLength(), uppercaseLetters.getBonusUppercaseLetters(), lowercaseLetters.getBonusLowercaseLetters(),
                          numbers.getBonusNumbers(), symbols.getBonusSymbols(), middleNumbersOrSymbols.getBonusMiddleNumberOrSymbols(),
                          requirements.getBonusRequirements(), lettersOnly.getBonusLettersOnly(), numbersOnly.getBonusNumbersOnly(),
                          repeatCharacters.getBonusRepeatCharacters(),consecutiveUppercaseLetters.getBonusConsecutiveUppercaseLetters(),
                          consecutiveLowercaseLetters.getBonusConsecutiveLowercaseLetters(), consecutiveNumber.getBonusConsecutiveNumber(),
                          sequentialLetters.getBonusSequentialLetters(), sequentialNumbers.getBonusSequentialNumbers(), sequentialSymbols.getBonusSequentialSymbols());
    }

    @Override
    public String toString() {
        return "Password: " + password
                + "\nScore: " + score.getScore()
                + "\nComplexity: " + score.getsComplexity()

                + "\nAddictions"
                + "\n[C: " + numberOfCharacters.getCountLength() + " | B: " + numberOfCharacters.getBonusLength() + "] Number of Characters"
                + "\n[C: " + uppercaseLetters.getCountUppercaseLetters() + " | B: " + uppercaseLetters.getBonusUppercaseLetters() + "] Uppercase Letters"
                + "\n[C: " + lowercaseLetters.getCountLowercaseLetters() + " | B: " + lowercaseLetters.getBonusLowercaseLetters() + "] Lowercase Letters"
                + "\n[C: " + numbers.getCountNumbers() + " | B: " + numbers.getBonusNumbers() + "] Numbers"
                + "\n[C: " + symbols.getCountSymbols() + " | B: " + symbols.getBonusSymbols() + "] Symbols"
                + "\n[C: " + middleNumbersOrSymbols.getCountMiddleNumbersOrSymbols() + " | B: " + middleNumbersOrSymbols.getBonusMiddleNumberOrSymbols() + "] Middle Numbers or Symbols"
                + "\n[C: " + requirements.getCountRequirements() + " | B: " + requirements.getBonusRequirements() + "] Requirements"

                + "\nDeductions"
                + "\n[C: " + lettersOnly.getCountLettersOnly() + " | B: " + lettersOnly.getBonusLettersOnly() + "] Letters Only"
                + "\n[C: " + numbersOnly.getCountNumbersOnly() + " | B: " + numbersOnly.getBonusNumbersOnly() + "] Numbers Only"
                + "\n[C: " + repeatCharacters.getCountRepeatCharacters() + " | B: " + repeatCharacters.getBonusRepeatCharacters() + "] Repeat Characters (Case Insensitive)"
                + "\n[C: " + consecutiveUppercaseLetters.getCountConsecutiveUppercaseLetters() + " | B: " + consecutiveUppercaseLetters.getBonusConsecutiveUppercaseLetters() + "] Consecutive Uppercase Letters"
                + "\n[C: " + consecutiveLowercaseLetters.getCountConsecutiveLowercaseLetters() + " | B: " + consecutiveLowercaseLetters.getBonusConsecutiveLowercaseLetters() + "] Consecutive Lowercase Letters"
                + "\n[C: " + consecutiveNumber.getCountConsecutiveNumber() + " | B: " + consecutiveNumber.getBonusConsecutiveNumber() + "] Consecutive Numbers"
                + "\n[C: " + sequentialLetters.getCountSequentialLetters() + " | B: " + sequentialLetters.getBonusSequentialLetters() + "] Sequential Letters"
                + "\n[C: " + sequentialNumbers.getCountSequentialNumbers() + " | B: " + sequentialNumbers.getBonusSequentialNumbers() + "] Sequential Numbers"
                + "\n[C: " + sequentialSymbols.getCountSequentialSymbols() + " | B: " + sequentialSymbols.getBonusSequentialSymbols() + "] Sequential Symbols";
    }
}