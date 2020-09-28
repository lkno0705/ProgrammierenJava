package de.dhbwka.java.exercise.classes;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Nimmspiel {
    private static final Random ngr = new Random();
    private Scanner scan = new Scanner(System.in);
    private String player1, player2;
    private ArrayList<String> stack1 = new ArrayList<String>();
    private ArrayList<String> stack2 = new ArrayList<String>();

    Nimmspiel(String player1, String player2) {
        this.player1 = player1;
        this.player2 = player2;
        for (int i = 0; i < ngr.nextInt(10); i++) stack1.add("k" + i);
        for (int i = 0; i < ngr.nextInt(10); i++) stack2.add("k" + i);
    }

    public String getPlayer1() {
        return player1;
    }

    public String getPlayer2() {
        return player2;
    }

    @Override
    public String toString() {
        return "Nimmspiel{" +
                "player1='" + player1 + '\'' +
                ", player2='" + player2 + '\'' +
                ", stack1=" + stack1 +
                ", stack2=" + stack2 +
                '}';
    }

    public int inputNumber(ArrayList<String> stack) {
        int inp;
        while (true) {
            try {
                inp = scan.nextInt();
                if (inp <= stack.size()) return inp;
                else System.out.println("the number is too big! The current Stack size is: " + stack.size());
            } catch (Exception e) {
                System.out.println("Enter an int!");
                scan = new Scanner(System.in);
            }
        }
    }

    public ArrayList<String> inputStack() {
        int stack;
        while (true) {
            try {
                stack = scan.nextInt();
                switch (stack) {
                    case 1:
                        if (stack1.size() != 0) return stack1;
                        else {
                            System.out.println("Stack 1 is already empty!");
                            break;
                        }
                    case 2:
                        if (stack2.size() != 0) return stack2;
                        else {
                            System.out.println("Stack 2 is already empty!");
                            break;
                        }
                }
            } catch (Exception e) {
                System.out.println("Enter an int!");
                scan = new Scanner(System.in);
            }
        }
    }

    public void drawBalls(String player) {
        System.out.println("Player " + player + "choose your stack: ");
        ArrayList<String> stack = inputStack();
        System.out.println("Player " + player + "choose your number: ");
        int number = inputNumber(stack);
        int initialStackSize = stack.size();
        for (int i = 0; i < number; i++) stack.remove(initialStackSize - 1 - i);
        return;
    }

    public boolean checkwin() {
        return stack1.size() == 0 && stack2.size() == 0;
    }

    public static void main(String[] args) {
        Nimmspiel a = new Nimmspiel("Hans", "Peter");
        System.out.println(a.toString());
        while (true) {
            a.drawBalls(a.player1);
            if (a.checkwin()) {
                System.out.println("Player: " + a.player1 + " wins!");
                System.exit(0);
            }
            a.toString();
            a.drawBalls(a.player2);
            if (a.checkwin()) {
                System.out.println("Player: " + a.player2 + " wins!");
                System.exit(0);
            }
        }
    }
}
