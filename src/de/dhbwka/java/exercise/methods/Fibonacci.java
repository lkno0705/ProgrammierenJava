package de.dhbwka.java.exercise.methods;

import java.util.Scanner;

public class Fibonacci {
    public static double fib(int n){
        switch (n){
            case 1: return 1;
            case 2: return 1;
            default: return fib(n-1) + fib(n-2);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Gib n ein: ");
        int n = scanner.nextInt();
        System.out.println(fib(n));
    }
}
