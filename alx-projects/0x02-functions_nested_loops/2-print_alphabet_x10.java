/**
 * Write a function that prints the alphabet x10, in lowercase, followed by a new line.
 *
 * Prototype: void print_alphabet_x10(void);
 */

class PrintAlphabet_x10 {
	public static void main(String[] args) {
		print_alphabet_x10();
	}

	public static void print_alphabet_x10() {
		for (int i = 0; i < 10; i++) {
			for (char c = 'a'; c <= 'z'; c++) {
				System.out.print(c);
			}
			System.out.println();
		}
	}
}
