package de.dhbwka.java.exercise.datatypes.shortvalue;

public class ShortValue {
    public static void main(String[] args){
        short s = 32767;
        System.out.println(s);
        s++;
        System.out.println(s); //Wert wird nach der Erhöhung um 1 negativ
        /*
        * Wert wird negativ da short nur 2^15-1 Werte im positiven Bereich ausgeben kann, allerding 2^15 Werte im
        * negativen Bereich
        */

    }
}
