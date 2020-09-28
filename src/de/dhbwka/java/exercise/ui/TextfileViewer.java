package de.dhbwka.java.exercise.ui;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class TextfileViewer {

    TextfileViewer(){
         JFileChooser fc = new JFileChooser();
         fc.setFileFilter(new FileFilter() {
             @Override
             public boolean accept(File f) {
                 return f.isDirectory() || f.getName().toLowerCase().endsWith(".txt");
             }

             @Override
             public String getDescription() {
                 return "Text Files";
             }
         });
         int state = fc.showOpenDialog(null);
         if (state == JFileChooser.APPROVE_OPTION){
             String path = fc.getSelectedFile().getAbsolutePath();
             ArrayList<String> lines = new ArrayList<>();
             try(FileReader fr = new FileReader(path); BufferedReader br = new BufferedReader(fr)){
                 while(br.ready()){
                     lines.add(br.readLine());
                 }
                 labels(lines, path);
                 textArea(lines, path);

             }catch(IOException e) {
                 e.printStackTrace();
             }

         }
    }

    private void labels(ArrayList<String> lines, String path){
        JFrame frame = new JFrame();
        frame.setTitle(path);
        frame.setSize(640, 480);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(10, 1, 1, 1));
        int i = 0;
        for (String line:lines) {
            if(!(i<10)) break;
            else{
                JLabel jLabel = new JLabel(line);
                frame.add(jLabel);
                i++;
            }
        }
        frame.setVisible(true);
    }

    private void textArea(ArrayList<String> lines, String path){
        JFrame frame = new JFrame();
        frame.setTitle(path);
        frame.setSize(640, 480);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        StringBuilder sb = new StringBuilder();
        for (String line:lines) sb.append(line + System.lineSeparator());
        frame.add(new JScrollPane(new JTextArea(sb.toString())));
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new TextfileViewer();
    }
}
