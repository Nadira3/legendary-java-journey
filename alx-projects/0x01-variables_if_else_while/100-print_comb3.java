/**
 * Write a program that prints all possible different combinations of two digits.
 * Numbers must be separated by ,, followed by a space
 * The two digits must be different
 *
 * 01 and 10 are considered the same combination of the two digits 0 and 1
 * Print only the smallest combination of two digits
 * Numbers should be printed in ascending order, with two digits
 * You are not allowed to use any variable of type char
 *
 * All your code should be in the main function
 */

class PrintComb3 {
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			for (int j = i + 1; j < 10; j++) {
				System.out.print(i);
				System.out.print(j);
				if (i != 8 || j != 9) {
					System.out.print(", ");
				}
			}
		}
		System.out.print("\n");
	}
}

// java style
class PrintComb3 {
    public static void main(String[] args) {
        printCombinations();
    }

    static void printCombinations() {
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < 10; i++) {
            for (int j = i + 1; j < 10; j++) {
                result.append(i).append(j);
                if (i != 8 || j != 9) {
                    result.append(", ");
                }
            }
        }
        
        System.out.println(result);
    }
}
