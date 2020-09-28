package de.dhbwka.java.exercise.control;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Babylon {
    public static void main(String[] args) {

        DecimalFormat format = new DecimalFormat("#0.000000");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Geben sie eine Zahl vom Datentyp Double ein: ");
        double a = scanner.nextDouble();

        System.out.println("Die sqrt von " + a + " ist " + format.format(Heron(a)));
    }

    private static double Heron(double a){
        double y = 0;
        if (a!=0){
            double x = a;
            while ( x > 0){
                y = (x + a /x) / 2;
                if (x-y < 10E-6) break;
                System.out.println("xn: " + x);
                x = y;
            }
            return y;
        }
        else return y;
    }
}
