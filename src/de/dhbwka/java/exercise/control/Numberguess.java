package de.dhbwka.java.exercise.control;

import java.util.Scanner;

public class Numberguess {
    public static void main(String[] args) {
        boolean again = true;

        System.out.println("In diesem Spiel geht es darum, mit möglichst wenig zügen eine Zahl zwischen 1 - 100 zu raten. \nBitte gebe deinen Namen ein: ");
        String name = InputStr();
        System.out.println("Hallo " + name);

        while(again) {
            Guessing();
            again = Playagain();
        }
    }

    private static String InputStr(){
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        return input;
    }

    private static int Guess(){
        while (true) {
            System.out.println("Rate eine Zahl zwischen 1-100: ");
            try {
                Scanner scanner = new Scanner(System.in);
                int input = scanner.nextInt();
                return input;
            }catch (Exception e){
                System.out.println("Please enter a number between 1 - 100!");
            }

        }
    }

    private static void Guessing(){
        int number = (int) (Math.random()*100);
        int trys = 0;
        int guess;
        while (true) {
            guess = Guess();
            if (guess == number){
                System.out.println("Die Zahl " + guess + " ist korrekt, du hast " + trys + " Versuche benötigt.");
                break;
            } else if(guess<number) System.out.println("Die Zahl ist größer als " + guess);
            else System.out.println("Die Zahl ist kleiner als " + guess);
            trys++;
        }
    }

    private static boolean Playagain(){
        System.out.println("Möchtest du nochmal spielen? (y/n): ");
        String answer = InputStr();
        return answer.equals("y") | answer.equals("Y");
    }
}
