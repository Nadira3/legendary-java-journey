import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class PutsChecker {
    public static void main(String[] args) {
        try {
            // Compile the program
            Process compileProcess = Runtime.getRuntime().exec("javac Puts.java");
            int compileResult = compileProcess.waitFor();
            
            if (compileResult != 0) {
                System.err.println("Compilation failed!");
                System.exit(1);
            }
            
            // Run the program and capture output
            Process runProcess = Runtime.getRuntime().exec("java Puts");
            
            // Read the output
            BufferedReader reader = new BufferedReader(
                new InputStreamReader(runProcess.getInputStream())
            );
            
            String output = reader.readLine();
            int exitCode = runProcess.waitFor();
            
            // Check the output
            boolean outputCorrect = "\"Programming is like building a multilingual puzzle".equals(output);
            boolean exitCodeCorrect = (exitCode == 0);
            
            // Display results
            System.out.println("Output check: " + (outputCorrect ? "PASS" : "FAIL"));
            System.out.println("Exit code check: " + (exitCodeCorrect ? "PASS" : "FAIL"));
            
            if (outputCorrect && exitCodeCorrect) {
                System.out.println("All tests passed!");
            } else {
                System.out.println("Tests failed!");
                if (!outputCorrect) {
                    System.out.println("Expected: \"Programming is like building a multilingual puzzle");
                    System.out.println("Got: " + output);
                }
                if (!exitCodeCorrect) {
                    System.out.println("Expected exit code: 0");
                    System.out.println("Got exit code: " + exitCode);
                }
            }
            
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
