package de.dhbwka.java.exercise.arrays;

import java.util.Random;

public class StandardDeviation {
    public static void main(String[] args) {
        int[] arr = new int[100];
        Random generator = new Random();
        for (int i=0; i<=arr.length-1; i++) arr[i] = generator.nextInt(10);
        int sum = 0;
        for (int val: arr) sum += val;
        double Mittelwert = 1.0/arr.length * sum;
        System.out.println("Mittelwert: " + Mittelwert);
        sum = 0;
        for (int val:arr) sum += Math.pow(val - Mittelwert, 2);
        System.out.println("Standardabweichung: " + (Math.sqrt(1.0/(arr.length-1) * sum)));
    }
}
