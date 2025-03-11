import java.util.Random;

class generateRandomDigit{
	public static void main(String[] args){

		// Using random class
		// Using nextInt without a range to generate potential negative numbers
		Random rand = new Random();
		int num = rand.nextInt();
		System.out.println("Random Integers: "+num);

		// Using Math.random() which returns a double
		double num2 = Math.random();
		System.out.println("Random Double: "+num2);

		// Using Math.random to generate an integer
		int num3 = (int)(Math.random() * 100);
		System.out.println("Random Integers: "+num3);

		int num4 = rand.nextInt(100); // Between 0 and 100
		System.out.println("Random Integers: "+num4);

		/**
		 * The output of the program should be:
		 * 	The string Last digit of, followed by
		 * 	n, followed by
		 * 	the string is, followed by
		 * 		if the last digit of n is greater than 5: the string and is greater than 5
		 * 		if the last digit of n is 0: the string and is 0
		 * 		if the last digit of n is less than 6 and not 0: the string and is less than 6 and not 0
		 * followed by a new line
		 */

		int last_digit = num % 10;
		if (num > 5) {
			System.out.println("Last digit of " + num + " is " + last_digit + " and is greater than 5");
		} else if (num == 0) {
			System.out.println("Last digit of " + num + " is 0 and is 0");
		} else {
			System.out.println("Last digit of " + num + " is " + last_digit + " and is less than 6 and not 0");
		}

	}
}

