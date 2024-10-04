package com.precious.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {

    // Static method to create a file if it doesn't exist
    public static void createFileIfNotExists(String fileName) {
        File file = new File(fileName);
        if (!file.exists()) {
            try {
                file.createNewFile();
                System.out.println("File created: " + fileName);
            } catch (IOException e) {
                System.out.println("An error occurred while creating the file.");
                e.printStackTrace();
            }
        }
    }

    // Static method to write a list of objects to the file
    public static <T> void writeObjectsToFile(String fileName, List<T> objects) {
        createFileIfNotExists(fileName);  // Ensure the file exists before writing

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(objects);  // Serialize and write the list to the file
        } catch (IOException e) {
            System.out.println("An error occurred while writing objects to the file.");
            e.printStackTrace();
        }
    }

    // Static method to read a list of objects from the file
    @SuppressWarnings("unchecked")
    public static <T> List<T> readObjectsFromFile(String fileName) {
        List<T> objects = new ArrayList<>();
        File file = new File(fileName);

        if (file.exists() && file.length() > 0) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
                objects = (List<T>) ois.readObject();  // Deserialize the list from the file
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("An error occurred while reading objects from the file.");
                e.printStackTrace();
            }
        }

        return objects;
    }

    // Static method to check if a unique identifier exists in a list of objects
    public static <T> boolean isIdentifierUnique(List<T> objects, UniqueIdentifierChecker<T> checker, String id) {
        for (T object : objects) {
            if (checker.isIdMatch(object, id)) {
                return false;  // Identifier already exists
            }
        }
        return true;  // Identifier is unique
    }

    // Functional interface for checking unique identifiers
    @FunctionalInterface
    public interface UniqueIdentifierChecker<T> {
        boolean isIdMatch(T object, String id);
    }
}
