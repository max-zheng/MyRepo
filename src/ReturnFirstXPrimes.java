import java.util.ArrayList;
import java.util.Scanner;

public class ReturnFirstXPrimes {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of primes you'd like to calculate: ");
        int numberOfPrimes = input.nextInt();
        ArrayList<Long> primes = new ArrayList<Long>();
        long primeNumber = 2;
        primes.add(primeNumber);
        while (primes.size() < numberOfPrimes) {
            long nextPrime = findNextPrime(primeNumber);
            primes.add(nextPrime);
            primeNumber = nextPrime;
        }
        System.out.println(primes);
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
}
