public class CheckIfNumberIsPrime extends PrimeNumber{

	public static void main(String[] args) {
		boolean testAgain = true;
		while(testAgain == true) {

			long number = assignLongVariableThroughScanner("Enter an integer: ");
			boolean numberIsPrime = evaluateNumber(number);

			System.out.print("The Number " + number + " is ");
			if (numberIsPrime) System.out.println("prime!");
			else System.out.println("not prime!");

			testAgain = allowUserToTestAgain();
		}


	}

	protected static boolean evaluateNumber(long number) {
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
