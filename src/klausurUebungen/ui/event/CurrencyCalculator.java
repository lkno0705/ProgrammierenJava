package klausurUebungen.ui.event;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class CurrencyCalculator {

    private final JFrame frame = new JFrame();

    CurrencyCalculator(){
        frame.setTitle("Currency converter");
        frame.setSize(300,100);
        frame.setLayout(new BorderLayout(5,5));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField textField = new JTextField("Please enter amount to convert!");

        frame.add(textField, BorderLayout.NORTH);

        JButton etu = new JButton("EUR -> USD");
        JButton ute = new JButton("USD -> EUR");
        JButton cancel = new JButton("Cancel");

        textField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                textField.setText(null);
            }

            @Override
            public void focusLost(FocusEvent e) {
            }
        });

        etu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = textField.getText();
                try {
                    float inputFloat = Float.parseFloat(input);
                    textField.setText(String.valueOf(inputFloat * 1.09));
                }
                catch (NumberFormatException exception){
                    textField.setText("GIB NE KOMMA ZAHL EIN DU LINKSVERSIFFTER DRECKSSACK!");
                }
            }
        });

        ute.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = textField.getText();
                try {
                    float inputFloat = Float.parseFloat(input);
                    textField.setText(String.valueOf(inputFloat / 1.09));
                }
                catch (NumberFormatException exception){
                    textField.setText("GIB NE KOMMA ZAHL EIN DU LINKSVERSIFFTER DRECKSSACK!");
                }
            }
        });

        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        frame.add(etu, BorderLayout.WEST);
        frame.add(ute, BorderLayout.CENTER);
        frame.add(cancel, BorderLayout.EAST);
        frame.setVisible(true);
    }


    public static void main(String[] args) {
        new CurrencyCalculator();
    }

}
