/**
 * Write a program that prints all possible different combinations of three digits.
 *
 * Numbers must be separated by ',', followed by a space
 * The three digits must be different
 * 012, 120, 102, 021, 201, 210 are considered the same combination of the three digits 0, 1 and 2
 * Print only the smallest combination of three digits
 * Numbers should be printed in ascending order, with three digits
 * You are not allowed to use any variable of type char
 * All your code should be in the main function
 */

// java style
class PrintComb4 {
    public static void main(String[] args) {
        printCombinations();
    }

    static void printCombinations() {
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < 10; i++) {
            for (int j = i + 1; j < 10; j++) {
		for (int k = j + 1; k < 10; k++) {
			result.append(i).append(j).append(k);
                	if (i != 7 || j != 8 || k != 9) {
                    		result.append(", ");
			}
                }
            }
        }
        
        System.out.println(result);
    }
}
