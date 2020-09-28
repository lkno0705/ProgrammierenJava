package de.dhbwka.java.exercise.datatypes.kaufmannischesrunden;

public class KaufmannischesRunden {
    public static void main(String[] args){
        final double pi = 3.1415926; // Naeherung der Kreiszahl Pi
        final double e = 2.7182818; // Naeherung der Eulerschen Zahl e
        int piInt = (int) pi;
        int eInt = (int) e;
        System.out.println("Pi ganzzahlig: " + piInt); // Ausgabe: 3
        System.out.println("e ganzzahlig: " + eInt); // Ausgabe: 2

        System.out.println("round(1.65) = " + round(1.65));
        System.out.println("round(1.3) = " + round(1.3));
        System.out.println("round(-1.3) = " + round(-1.3));
        System.out.println("round(-1.65) = " + round(-1.65));
    }
     private static int round(double n){
        if (n >= 0 & n - (int) n >= 0.5){
            return (int) n + 1;
        }
        else if (n - (int) n <= -0.5){
            return (int) n-1;
         }
        else return (int) n;
     }
}
