import java.util.Scanner;

public class PrimeNumber {

	public static void main(String[] args) {
		System.out.println("checking if 2 is prime " + checkIfNumberIsPrime(2));
		int again;
		do {
			Scanner input = new Scanner(System.in);
			System.out.print("Enter an integer: ");
			long number = input.nextLong();

			boolean numberIsPrime = checkIfNumberIsPrime (number);

			System.out.print("The Number " + number + " is ");
			if(numberIsPrime) System.out.println("prime!");
			else System.out.println("not prime!");
			System.out.print("Test another number? 1 = yes");
			again = input.nextInt();

		} while(again == 1);


	}

	protected static boolean checkIfNumberIsPrime(long number) {
		if(number == 1 || number == 0) {
			return false;
		}
		boolean isPrime = true;
		for(int i = 2; i <= (long)Math.sqrt(number); i++) {
			if(number % i == 0 && number != i) {
				isPrime = false;
				break;
			}
		}
		return isPrime;
	}
}
