package de.dhbwka.java.exercise.arrays;

public class Pascal {
    public static void main(String[] args) {
        int[][] pascal = new int[9][];
        for (int i = 0; i < pascal.length; i++) {
            pascal[i] = new int[i + 1];
            for (int j = 0; j < pascal[i].length; j++) {
                if (j == 0 || j == pascal[i].length - 1) pascal[i][j] = 1;
                else pascal[i][j] = pascal[i - 1][j - 1] + pascal[i - 1][j];
                System.out.print(pascal[i][j] + " ");
            }
            System.out.print("\n");
        }

    }
}
