import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class FindPrimeFactorization {

	public static void main(String[] args) {
		int again;
		do {
			Scanner input = new Scanner(System.in);
			System.out.print("Enter a number: ");
			long numberValue = input.nextLong();

			
			while(numberValue <= 1) {
				System.out.print("\nPlease enter a valid number. The number must be greater than 1: ");
				numberValue = input.nextLong();
			}

			if(CheckIfNumberIsPrime.evaluateNumber(numberValue)) {
				System.out.println("The prime factorization of " + numberValue + " is " + numberValue + " * 1");
				System.out.print("\nCalculate prime factorization for another number? 1 = yes ");
				again = input.nextInt();
				continue;
			}
			buildListOfPrimeFactors(numberValue);

			System.out.print("\nCalculate prime factorization for another number? 1 = yes ");
			again = input.nextInt();
		} while(again == 1);

	}

	private static void buildListOfPrimeFactors(long numberValue) {
		long number = numberValue;
		List<Long> listOfPrimeFactors = new ArrayList<Long>();
		while(multiplyPrimeFactors(listOfPrimeFactors) != numberValue) {
            long primeFactor = getAPrimeFactor(number);
            listOfPrimeFactors.add(primeFactor);
            number /= primeFactor;
        }
		System.out.println("The prime factorization of " + numberValue + " is " + formatPrimeFactorization(listOfPrimeFactors));
	}

	private static long getAPrimeFactor(long number) {
		long prime = 2;
		while(true) {
			if(number % prime == 0) {
				return prime;
			}
			prime = ReturnFirstXPrimes.findNextPrime(prime);
		}
	}
	
	private static long multiplyPrimeFactors(List<Long> listOfPrimeFactors) {
		long product = 1;
		for(Long prime: listOfPrimeFactors) {
			product *= prime;
		}
		return product;
	}
	
	private static String formatPrimeFactorization(List<Long> listOfPrimeFactors) {
		String display = "";
		for(int i = 0; i < listOfPrimeFactors.size();i++) {
			int numOfOccurences = Collections.frequency(listOfPrimeFactors, listOfPrimeFactors.get(i));
			display += listOfPrimeFactors.get(i); 
			if(numOfOccurences > 1) {
				display += "^" + Integer.toString(numOfOccurences);
				i += numOfOccurences -1;
			}
			display += " * ";
				
		}
		display = display.substring(0, display.length() - 2);
		return display;
	}
}
