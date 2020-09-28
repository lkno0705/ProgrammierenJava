package de.dhbwka.java.exercise.threads;

import de.dhbwka.java.exercise.ui.paint.Election;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class DancingText extends JFrame implements Runnable {

    String text;
    char[] chars;
    Component draw;
    Thread thread;

    public class charcomponent extends JComponent{

        int x;

        charcomponent(){
            this.x = 0;
        }

        @Override
        protected void paintComponent(Graphics g){
            Random random = new Random();
            this.setBackground(Color.BLACK);
            g.setFont(new Font("Helvetica", Font.BOLD, 30));
            for (int i = 0; i < DancingText.this.chars.length; i++) {
                g.setColor(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
                g.drawString(Character.toString(DancingText.this.chars[i]), 10+40*i, (int)(Math.sin(Math.PI*i/4 + this.x/8)*40)+this.getHeight()/2);
            }
            x++;
        }
    }

    public void run(){
        while (true){
            this.draw.repaint();
            this.repaint();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    DancingText(String text){
        this.text = text;
        this.chars = this.text.toCharArray();
        this.draw = new charcomponent();
        this.add(draw);
        setBackground(Color.BLACK);
        setTitle("Dancing Text");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000,400);
        setVisible(true);
        this.thread = new Thread(this);
        this.thread.start();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 12; i++) {
            new DancingText("IHR LINKSVERSIFFTEN SCHWEINE");
        }
    }

}
