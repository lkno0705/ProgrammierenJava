package de.dhbwka.java.exercise.control;

public class Deers {
    public static void main(String[] args) {
        int hirsch = 200;
        while (hirsch <= 300){
            hirsch = (int) (hirsch + (hirsch * 0.1) - 15);
            System.out.println(hirsch);
        }
    }
}
