package de.dhbwka.java.exercise.strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RomanNumber {

    private static final Scanner scanner = new Scanner(System.in);
    private static final Map<String, Integer> romanNumbers = new HashMap<String, Integer>();
    static {
        romanNumbers.put("M", 1000);
        romanNumbers.put("D", 500);
        romanNumbers.put("C", 100);
        romanNumbers.put("L", 50);
        romanNumbers.put("X", 10);
        romanNumbers.put("V", 5);
        romanNumbers.put("I", 1);
    }

    public static void main(String[] args) {
        String str = scanner.nextLine();
        char[] charList = str.toCharArray();
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        int result = 0;

        for (int i = 0; i<charList.length; i++){
            switch (String.valueOf(charList[i])){
                case "I": if(charList.length-1 > i && (String.valueOf(charList[i+1]).equals("V") || String.valueOf(charList[i+1]).equals("X"))) {
                    numbers.add(romanNumbers.get(String.valueOf(charList[i + 1])) - romanNumbers.get("I"));
                    i++;
                    break;
                }
                case "X": if(charList.length-1 > i && (String.valueOf(charList[i+1]).equals("L") || String.valueOf(charList[i+1]).equals("C"))){
                    numbers.add(romanNumbers.get(String.valueOf(charList[i + 1])) - romanNumbers.get("X"));
                    i++;
                    break;
                }
                case "C": if(charList.length-1 > i && (String.valueOf(charList[i+1]).equals("D") || String.valueOf(charList[i+1]).equals("M"))){
                    numbers.add(romanNumbers.get(String.valueOf(charList[i + 1])) - romanNumbers.get("C"));
                    i++;
                }
                default: numbers.add(romanNumbers.get(String.valueOf(charList[i])));
            }
        }
        for (int val:numbers) result += val;
        System.out.println(result);
    }

}
