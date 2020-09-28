package klausurUebungen.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.desktop.SystemSleepEvent;
import java.io.*;

public class TextFrame extends JFrame {

    private String path;
    private int width;
    private int height;

    public TextFrame(String path, int width, int height) throws HeadlessException {
        this.path = path;
        this.width = width;
        this.height = height;
    }

    public static void main(String[] args) {

        if (args.length != 3){
            System.out.println("arg[0] = path to your file \narg[1] = width of Frame \narg[2] = height of Frame");
            System.exit(0);
        }
        else {

            try {
                TextFrame textFrame = new TextFrame(args[0], Integer.parseInt(args[1]), Integer.parseInt(args[2]));
                textFrame.display();
            } catch (NumberFormatException e) {
                System.out.println(e.toString());
            }
        }
    }


    private String readFile() {
        try {
            File f = new File(this.path);
            BufferedReader bufferedReader = new BufferedReader(new FileReader(f.getAbsolutePath()));
            StringBuilder content = new StringBuilder();
            String st;
            while ((st = bufferedReader.readLine()) != null) {
                content.append(st).append("\n");
            }
            return content.toString();
        }
        catch (IOException e) {
            e.printStackTrace();
            return e.toString();
        }
    }

    public void display() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(this.width, this.height);
        this.add(new JTextArea(this.readFile()));
        this.setTitle(this.path.split("/")[this.path.split("/").length -1]);
        this.setVisible(true);
    }

}
