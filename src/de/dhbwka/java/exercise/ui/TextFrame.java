package de.dhbwka.java.exercise.ui;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TextFrame extends JFrame {

    TextFrame(String filename, int width, int height){
        StringBuilder sb = new StringBuilder();
        this.setTitle(filename);
        this.setSize(width,height);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        try (FileReader fr = new FileReader(filename);
             BufferedReader reader = new BufferedReader(fr)) {
            while (reader.ready()){
                sb.append(reader.readLine() + System.lineSeparator());
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
        this.add(new JTextArea(sb.toString()));
        this.setVisible(true);
    }

    public static void main(String[] args) {

        if (args != null && args.length == 3) {
            try {
                new TextFrame(args[0], Integer.parseInt(args[1]), Integer.parseInt(args[2]));
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        else System.out.println("Usage: filename width height");
    }
}
