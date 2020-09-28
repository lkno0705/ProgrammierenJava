package de.dhbwka.java.exercise.control;

import javax.sound.midi.Soundbank;
import java.util.Scanner;

public class AddUp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int zahl = 0;
        do {
            int in = scanner.nextInt();
            if (!(in >= 0)) break;
            System.out.println(zahl += in);
        }while(true);
    }
}