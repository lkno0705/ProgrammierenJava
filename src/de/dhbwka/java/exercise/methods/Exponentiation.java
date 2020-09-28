package de.dhbwka.java.exercise.methods;

import java.util.Scanner;

public class Exponentiation {
    public static double xPowerN(double x, int n) {
        if (n == 0) return 1;
        else return x * xPowerN(x, n - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Gib x ein: ");
        double x = scanner.nextDouble();
        System.out.print("\nGib n ein: ");
        int n = scanner.nextInt();
        System.out.println(xPowerN(x, n));
    }
}
