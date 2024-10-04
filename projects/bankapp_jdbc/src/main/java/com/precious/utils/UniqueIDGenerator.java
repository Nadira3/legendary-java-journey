package com.precious.utils;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class UniqueIDGenerator {

    private static Set<String> generatedIds = new HashSet<>();
    private static final String NUMBERS = "0123456789";
    private static final String LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String MIXED = LETTERS + NUMBERS;

    /**
     * Generates a unique ID with only numbers.
     * @param prefix The prefix to add to the generated ID.
     * @param length The length of the numeric part of the ID (excluding the prefix).
     * @return A unique ID composed of the prefix followed by only numbers.
     */
    public static String generateNumericId(String prefix, int length) {
        return generateUniqueId(prefix, length, NUMBERS);
    }

    /**
     * Generates a unique ID with only letters.
     * @param prefix The prefix to add to the generated ID.
     * @param length The length of the alphabetic part of the ID (excluding the prefix).
     * @return A unique ID composed of the prefix followed by only letters.
     */
    public static String generateAlphabeticId(String prefix, int length) {
        return generateUniqueId(prefix, length, LETTERS);
    }

    /**
     * Generates a unique ID with a mix of letters and numbers.
     * @param prefix The prefix to add to the generated ID.
     * @param length The length of the alphanumeric part of the ID (excluding the prefix).
     * @return A unique ID composed of the prefix followed by a mix of letters and numbers.
     */
    public static String generateAlphanumericId(String prefix, int length) {
        return generateUniqueId(prefix, length, MIXED);
    }

    /**
     * Generates a unique ID based on the given character set.
     * @param prefix The prefix to add to the generated ID.
     * @param length The length of the ID part (excluding the prefix).
     * @param characterSet The character set to use for generating the ID (letters, numbers, or mixed).
     * @return A unique ID.
     */
    private static String generateUniqueId(String prefix, int length, String characterSet) {
        Random random = new Random();
        StringBuilder id;
        do {
            id = new StringBuilder(prefix);
            for (int i = 0; i < length; i++) {
                int index = random.nextInt(characterSet.length());
                id.append(characterSet.charAt(index));
            }
        } while (generatedIds.contains(id.toString())); // Ensure uniqueness
        generatedIds.add(id.toString());
        return id.toString();
    }

    /**
     * Clears all the generated IDs (useful for system reset).
     */
    public static void clearGeneratedIds() {
        generatedIds.clear();
    }

    /**
     * Checks if a specific ID has already been generated.
     * @param id The ID to check.
     * @return true if the ID already exists, false otherwise.
     */
    public static boolean doesIdExist(String id) {
        return generatedIds.contains(id);
    }
}
