import java.util.Scanner;

public class PrimeNumber {

    protected static final Scanner input = new Scanner(System.in);

    protected static long assignLongVariableThroughScanner(String message) {
        System.out.print(message);
        return input.nextLong();
    }

    protected static int assignIntVariableThroughScanner(String message) {
        System.out.print(message);
        return input.nextInt();
    }

    protected static boolean allowUserToTestAgain() {
        System.out.print("Test another number? 1 = yes ");
        if (input.nextInt() == 1) return true;
        return false;
    }
}
