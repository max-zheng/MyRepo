import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReturnFirstXPrimes {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of primes you'd like to calculate: ");
        int numberOfPrimes = input.nextInt();

        while(numberOfPrimes <= 0) {
            System.out.println("Please enter a positive number.");
            numberOfPrimes = input.nextInt();
        }
        List<Long> primes = new ArrayList<Long>();
        long primeNumber = 2;
        primes.add(primeNumber);
        while (primes.size() < numberOfPrimes) {
            long nextPrime = findNextPrime(primeNumber);
            primes.add(nextPrime);
            primeNumber = nextPrime;
        }
        System.out.println(buildPrimeDisplay(primes));
    }

    protected static Long findNextPrime(long previousPrime) {
        PrimeNumber p = new PrimeNumber();
        long number = previousPrime++;
        while (true) {
            if (p.checkIfNumberIsPrime(++number)) {
                return number;
            }
        }
    }

    private static String buildPrimeDisplay( List<Long> primes) {
        StringBuilder builder = new StringBuilder();
        builder.append("#1:2, ");
        for(int i = 1; i < primes.size(); i++) {
            builder.append("#" + (i + 1) + ":" + primes.get(i) + ", ");
            if(i % 50 == 0) {
                builder.append("\n");
            }
        }
        builder.delete(builder.length() - 2, builder.length());
        return builder.toString();
    }
}
