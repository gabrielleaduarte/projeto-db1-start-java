package refactored;

public class Main {
    public static void main(String[] args) {
        RefactoredCode check = new RefactoredCode();
        check.checkPassword("abc123#$%");
        System.out.println(check);
    }
}