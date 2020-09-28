package de.dhbwka.java.exercise.arrays;

import java.util.Scanner;

public class DotProduct {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int elementsum = 0;
        int x;
        int y;
        //Inputs
        System.out.println("Please make sure that both Vektors have the same amount of elements!");
        System.out.print("Enter every Element of the first Vektor divided by , : ");
        String[] elementStringV1 = scanner.nextLine().split(",");
        System.out.print("Enter every Element of the second Vektor divided by , : ");
        String[] elementStringV2 = scanner.nextLine().split(",");

        for (int i=0; i<elementStringV1.length; i++){
            //delete every space characte in element and parse it to an int
            x = Integer.parseInt(elementStringV1[i].replaceAll("\\s", ""));
            y = Integer.parseInt(elementStringV2[i].replaceAll("\\s", ""));

            elementsum += x * y;
        }
        System.out.println("Das Skalar produkt lautet: " + elementsum);
    }
}
