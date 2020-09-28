package de.dhbwka.java.exercise.strings;

import java.io.*;
import java.util.Scanner;

public class Palindrome {

    private static final Scanner scanner = new Scanner(System.in);

    private final String path;
    private String fContent;
    private final String palindrome;

    public Palindrome(String path, String palindrome) throws IOException {
        this.path = path;
        this.readFile();
        this.palindrome = palindrome;
    }

    public static void main(String[] args) throws IOException {

        System.out.println("Enter path");
        String path = scanner.nextLine();
        System.out.println("Enter palindrome");
        String strPalindrome = scanner.nextLine();

        Palindrome palindrome = new Palindrome(path, strPalindrome);
        palindrome.checkPalin();
    }

    public void checkPalin() throws IOException {
        StringBuffer strBuffr = new StringBuffer(this.palindrome);
        strBuffr.reverse();
        if(this.palindrome.equals(strBuffr.toString())){
            System.out.println("Palindrome: True");
            this.fContent += strBuffr.toString();
        }
        else System.out.println("Palindrome : False");
        this.writeFile();
    }

    public void readFile() throws IOException {
        File f = new File(this.path);
        if (!f.exists()){
            f.createNewFile();
            this.fContent =  "";
        }
        else {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(f.getAbsolutePath()));
            String st;
            String fContent = "";
            while ((st = bufferedReader.readLine()) != null) {
                fContent += st + "\n";
            }
            this.fContent = fContent;
        }
    }

    public void writeFile() throws IOException {
        File f = new File(this.path);
        FileWriter fileWriter = new FileWriter(f.getAbsolutePath());
        fileWriter.write(this.fContent);
        fileWriter.close();
    }
}