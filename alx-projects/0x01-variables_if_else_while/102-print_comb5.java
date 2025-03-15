/**
 * Write a program that prints all possible combinations of two two-digit numbers.
 *
 * The numbers should range from 0 to 99
 * The two numbers should be separated by a space
 * All numbers should be printed with two digits. 1 should be printed as 01
 * The combination of numbers must be separated by comma, followed by a space
 * The combinations of numbers should be printed in ascending order
 * 00 01 and 01 00 are considered as the same combination of the numbers 0 and 1
 * You are not allowed to use any variable of type char
 * All your code should be in the main function
 */

class PrintComb5 {
	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			for (int j = i + 1; j < 100; j++) {
				System.out.printf("%02d %02d", i, j);
				if (i != 98 || j != 99) {
					System.out.print(", ");
				}
			}
		}
		System.out.println();
	}
}

