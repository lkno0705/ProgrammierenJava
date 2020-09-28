package de.dhbwka.java.exercise.operators.easter;
import java.util.Scanner;

public class Easter {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter Year");
        String jahr = scanner.nextLine();  // Read user input
        int ijahr = Integer.parseInt(jahr);
        int a = ijahr % 19;
        int b = ijahr % 4;
        int c = ijahr % 7;
        int k = ijahr / 100;
        int p = (8*k + 13) / 25;
        int q = k / 4;
        int m = (15 + k - p - q) % 30;
        int n = (4 + k - q) % 7;
        int d = (19*a + m) % 30;
        int e = (2*b + 4*c + 6*d + n) % 7;
        int ostern = (22 + d + e);
        if (ostern > 31){
            System.out.println("Ostern ist am: " + (ostern-31) + " April");
        }
        else System.out.println("Ostern ist am: " + ostern + " März");
    }
}
