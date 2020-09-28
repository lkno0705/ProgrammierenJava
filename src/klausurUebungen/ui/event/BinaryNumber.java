package klausurUebungen.ui.event;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BinaryNumber extends JFrame {

    private JToggleButton[] buttonArray;
    private JLabel resultField;

    BinaryNumber() {
        buildUI();
    }

    private void buildUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setName("Binary Number");
        setSize(500, 200);
        this.setLayout(new GridLayout(2, 1, 2, 2));

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2, 8, 2, 2));

        this.buttonArray = new JToggleButton[8];
        for (int i = buttonArray.length - 1; i >= 0; i--) {
            JToggleButton button = new JToggleButton();
            button.setIcon(new ImageIcon("./23_Events_Aufgaben-1_Icons/off.png"));
            button.setSelectedIcon(new ImageIcon("./23_Events_Aufgaben-1_Icons/on.png"));
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int sum = 0;
                    for (int x = buttonArray.length - 1; x >= 0; x--) {
                        if (buttonArray[x].isSelected()) {
                            sum += Math.pow(2, x);
                        }
                    }
                    resultField.setText(String.valueOf(sum));
                }
            });
            buttonArray[i] = button;
            buttonPanel.add(button);
        }
        for (int i = buttonArray.length - 1; i >= 0; i--) {
            buttonPanel.add(new JLabel("2^" + i, JLabel.CENTER));
        }

        add(buttonPanel);
        add((resultField = new JLabel("0", JLabel.CENTER)));
        setVisible(true);

    }

    public static void main(String[] args) {
        BinaryNumber b = new BinaryNumber();
    }

}
