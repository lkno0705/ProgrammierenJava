package de.dhbwka.java.exercise.operators.incrementdecrement;

public class IncrementDecrement {
    public static void main(String[] args) {
        int i=0;
        int j=0;
        j = ++i; // beides 1
        int k = j++ + ++i; //ergibt 3 nach der ausführung wird i,j = 2
        System.out.println("k: " + k);
        System.out.println("*: " + j++ + ++i); //23 wird zu einem String, i,j = 3
        System.out.println(j++ + ++i); //7, nach der ausführung wird i,j = 4
        int m = j++ * ++i; // m= 20, i,j = 5
        System.out.println("m: " + m);
        int n = --j * --i; //n=16, i,j=4
        System.out.println("n: " + n);
        System.out.println("i: " + i);
        System.out.println("j: " + j);
    }
}
