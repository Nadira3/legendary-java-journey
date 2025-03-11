/**
 * Write a program that prints all possible combinations of single-digit numbers.
 *
 * Numbers must be separated by ,, followed by a space
 * Numbers should be printed in ascending order
 * All your code should be in the main function
 * You are not allowed to use any variable of type char
 */


class CombNumbers {
	public static void main(String[] args) {
		for (int num = 0; num < 10; num++) {
			if (num < 9)
				System.out.print(num + ", ");
			else
				System.out.print(num);
		}
		System.out.println();
	}
}
