package de.dhbwka.java.exercise.arrays;

import java.util.Scanner;

public class Bubblesort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] list;
        boolean switched = true;

        System.out.println("Enter your list elements divided by , : ");
        String[] elements = scanner.nextLine().split(",");
        list = new int[elements.length];
        for (int i = 0; i < elements.length; i++) {
            list[i] = Integer.parseInt(elements[i].replaceAll("\\s", ""));
        }
        for (int k = 1; k < list.length; k++) {
            for (int i = 0; i < list.length - k; i++) {
                if (list[i] > list[i + 1]) {
                    int temp = list[i];
                    list[i] = list[i + 1];
                    list[i + 1] = temp;
                }
            }
        }
        System.out.print("Sorted: ");
        for (int i = 0; i < list.length; i++) System.out.print(list[i] + ", ");
    }
}
