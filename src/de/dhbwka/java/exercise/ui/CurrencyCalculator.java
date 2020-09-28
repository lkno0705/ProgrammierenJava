package de.dhbwka.java.exercise.ui;

import javax.swing.*;
import java.awt.*;

public class CurrencyCalculator extends JFrame {

    CurrencyCalculator(){
        setTitle("Currency converter");
        setSize(300,100);
        setLayout(new BorderLayout(5,5));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(new TextField("Please enter amount to convert!"), BorderLayout.NORTH);
        add(new JButton("EUR -> USD"), BorderLayout.WEST);
        add(new JButton("USD -> EUR"), BorderLayout.CENTER);
        add(new JButton("Cancel"), BorderLayout.EAST);
        setVisible(true);
    }


    public static void main(String[] args) {
        new CurrencyCalculator();
    }
}
