/**
 * Write a function that prints the alphabet, in lowercase, followed by a new line.
 *
 * Prototype: void print_alphabet(void);
 */

class PrintAlphabets {
	public static void main(String[] args) {
		print_alphabet();
	}

	public static void print_alphabet() {
		for (char c = 'a'; c <= 'z'; c++) {
			System.out.print(c);
		}
		System.out.println();
	}
}
