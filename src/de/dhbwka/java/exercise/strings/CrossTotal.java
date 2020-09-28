package de.dhbwka.java.exercise.strings;

import java.util.Scanner;

public class CrossTotal {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String str = scanner.nextLine();
        char[] splitted = str.toCharArray();
        int result = 0;
        for (char val:splitted) result += Character.getNumericValue(val);
        System.out.println("CrossTotal: " + result);
    }

}
