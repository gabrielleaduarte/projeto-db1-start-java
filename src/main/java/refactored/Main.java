package refactored;

public class Main {
    public static void main(String[] args) {
        RefactoredCode check = new RefactoredCode();
        check.checkPassword("ABC#$%123");
        System.out.println(check);
    }
}