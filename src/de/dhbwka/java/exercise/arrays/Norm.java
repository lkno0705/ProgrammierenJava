package de.dhbwka.java.exercise.arrays;

import java.util.Scanner;

public class Norm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int elementsum = 0;
        System.out.print("Geben sie alle Elemente des Vektors mit einem , getrennt ein: ");
        String[] elementstring = scanner.nextLine().split(",");
        // delete every space characters from elementstring and convert every element to an int and add it's square to the sum
        for (int i = 0; i<elementstring.length; i++) elementsum += Math.pow(Integer.parseInt(elementstring[i].replaceAll("\\s", "")), 2);
        System.out.println("Der Betrag des Vektors ist " + Math.sqrt(elementsum));
    }
}
