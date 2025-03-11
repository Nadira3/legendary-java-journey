import java.util.Random;

class generateRandom{
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
		 * Complete the source code in order to print whether the number stored
		 * in the variable n is positive or negative.
		 *
		 * The output of the program should be:
		 * 	The number, followed by
		 * 	if the number is greater than 0: is positive
		 * 	if the number is 0: is zero
		 * 	if the number is less than 0: is negative
		 * 	followed by a new line
		 */

		if (num > 0 || num == 0) {
			System.out.println(num + " is positive");
		} else
			System.out.println(num + " is negative");

	}
}

