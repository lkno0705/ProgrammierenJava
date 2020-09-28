package de.dhbwka.java.exercise.arrays;

import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int f0 = 1;
        int f1 = 2;
        int n = scanner.nextInt();
        long[] fibarr = new long[n];

        for (int i=0; i<n; i++){
            switch (i){
                case 0:
                    fibarr[i] = 1;
                    break;
                case 1:
                    fibarr[i] = 1;
                    break;
                default:
                    fibarr[i] = fibarr[i-1] + fibarr[i-2];
                    break;
            }
            System.out.println(fibarr[i]);
        }
    }
}
