import java.util.Scanner;

public class PrimeNumber {

	public static void main(String[] args) {
		int again;
		do {
			Scanner input = new Scanner(System.in);
			System.out.print("Enter an integer: ");
			long number = input.nextInt();
			
			boolean numberIsPrime = checkIfNumberIsPrime (number);
			
			System.out.print("The Number " + number + " is ");
			if(numberIsPrime) System.out.println("prime!");
			else System.out.println("not prime!");
			System.out.print("Test another number? 1 = yes");
			again = input.nextInt();

		} while(again == 1);
		
		
	}
	
	private static boolean checkIfNumberIsPrime(long number) {
		if(number == 1 || number == 0) {
			return false;
		}
		boolean isPrime = true;
		for(int i = 2; i <= (int)Math.sqrt(number); i++) {
			if(number % i == 0 && number != i) {
				isPrime = false;
			}
		}
		return isPrime;
	}
}
