package refactored;

public class Score {

    int score;
    String sComplexity = "Too Short";

    public Score(int numberOfCharacters, int uppercaseLetters, int lowercaseLetters, int numbers, int symbols,
                 int middleNumbersOrSymbols, int requirements, int lettersOnly, int numbersOnly, int repeatCharacters,
                 int consecutiveUppercaseLetters, int consecutiveLowercaseLetters, int consecutiveNumbers,
                 int sequentialLetters, int sequentialNumbers, int sequentialSymbols){
        calculateScore(numberOfCharacters, uppercaseLetters, lowercaseLetters, numbers, symbols, middleNumbersOrSymbols,
                       requirements, lettersOnly, numbersOnly, repeatCharacters, consecutiveUppercaseLetters,
                       consecutiveLowercaseLetters, consecutiveNumbers, sequentialLetters, sequentialNumbers, sequentialSymbols);
        setLimits();
        determineComplexity();
    }

    public void calculateScore(int numberOfCharacters, int uppercaseLetters, int lowercaseLetters, int numbers, int symbols,
                               int middleNumbersOrSymbols, int requirements, int lettersOnly, int numbersOnly, int repeatCharacters,
                               int consecutiveUppercaseLetters, int consecutiveLowercaseLetters, int consecutiveNumbers,
                               int sequentialLetters, int sequentialNumbers, int sequentialSymbols) {
        int additions = numberOfCharacters + uppercaseLetters + lowercaseLetters + numbers + symbols + middleNumbersOrSymbols +
                        requirements;
        int deductions = lettersOnly + numbersOnly + repeatCharacters + consecutiveUppercaseLetters + consecutiveLowercaseLetters +
                         consecutiveNumbers + sequentialLetters + sequentialNumbers + sequentialSymbols;
        score = additions - deductions;
    }

    public void setLimits() {
        if (score > 100) {
            score = 100;
        } else if (score < 0) {
            score = 0;
        }
    }

    public void determineComplexity() {
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

    public int getScore() {
        return score;
    }

    public String getsComplexity() {
        return sComplexity;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setsComplexity(String sComplexity) {
        this.sComplexity = sComplexity;
    }
}
