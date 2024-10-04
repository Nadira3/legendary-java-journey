public class ClassNotFoundDemo {
    public static void main(String[] args) {
        try {
            Class.forName("NonExistentClass");
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found");
        }

        System.out.println("Program continues after handling the exception.");
    }
}

