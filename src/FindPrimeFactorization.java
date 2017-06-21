import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class FindPrimeFactorization {
	long numberValue;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a number: ");
		long numberValue = input.nextLong();
		long number = numberValue;
		
		if(PrimeNumber.checkIfNumberIsPrime(number)) {
			System.out.println("The prime factorization of " + numberValue + " is " + number + " * 1");
			System.exit(0);
		}
		List<Integer> listOfPrimeFactors = new ArrayList<Integer>();
		while(multiplyPrimeFactors(listOfPrimeFactors) != numberValue) {
			int primeFactor = getAPrimeFactor(number);
			listOfPrimeFactors.add(primeFactor);
			number /= primeFactor;
		}
		System.out.println("The prime factorization of " + numberValue + " is " + formatPrimeFactorization(listOfPrimeFactors));
	}
	
	private static int getAPrimeFactor(long number) {
		for(int i = 2; i <= number; i++) {
			if(number % i == 0 && PrimeNumber.checkIfNumberIsPrime(i)) {
				return i;
			}
		}
		return -1;
	}
	
	private static long multiplyPrimeFactors(List<Integer> listOfPrimeFactors) {
		long product = 1;
		for(Integer prime: listOfPrimeFactors) {
			product *= prime;
		}
		return product;
	}
	
	private static String formatPrimeFactorization(List<Integer> listOfPrimeFactors) {
		String display = "";
		//String display = "";
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
