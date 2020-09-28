package de.dhbwka.java.exercise.ui;

import javax.swing.*;
import java.awt.*;

public class ComponentFrame extends JFrame {

    ComponentFrame(){
        // set Title
        this.setTitle("Several basic Swing Components");

        //creating JPanel
        JPanel panel = new JPanel();

        //Adding Components
        panel.add(new JLabel("JLabel"));
        panel.add(new JTextField("JTextField"));
        panel.add(new JPasswordField("JPasswordField"));
        JButton button = new JButton("JButton");
        button.setToolTipText("setToolTipText");
        panel.add(button);
        panel.add(new JToggleButton("JToggleButton"));
        panel.add(new JCheckBox("JCheckBox"));

        // creating ComboBox
        String[] comboBoxItems = {"Item 1", "Item 2", "Item 3", "Item 4"};
        panel.add(new JComboBox<String>(comboBoxItems));

        // creating ButtonGroup of RadioButtons
        ButtonGroup bg = new ButtonGroup();
        for(int i = 0; i < 3; i++){
            JRadioButton rb = new JRadioButton("JRadioButton" + i);
            bg.add(rb);
            panel.add(rb);
        }

        // Setting Frame settings
        this.add(panel);
        this.setSize(612, 100);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new ComponentFrame();
    }
}
