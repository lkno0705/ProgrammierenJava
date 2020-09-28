package klausurUebungen.ui;

import javax.swing.*;

public class ComponentFrame extends JFrame {
    public static void main(String[] args) {
        ComponentFrame frame = new ComponentFrame();
        JPanel panel = new JPanel();
        frame.setSize(400,200);
        panel.add(new JLabel("IK BIN EIN TOOOOOLES LABEL"));
        panel.add(new JTextField("IK BIN EIN TEXTFIELD"));
        panel.add(new JPasswordField("HIHIHUHUHAHA"));
        panel.add(new JButton("IK BIN EIN BUTTON"));
        panel.add(new JToggleButton("IK BIN EIN TOGGLEBUTTON"));
        panel.add(new JCheckBox("HIER IS EINE CHECKBOX"));
        JComboBox<String> comboBox = new JComboBox();
        comboBox.addItem("HUHU");
        comboBox.addItem("HAHA");
        comboBox.addItem("TSCHU THSCU");
        panel.add(comboBox);
        panel.add(new JRadioButton("SCHWULER RADIO"));
        panel.add(new JRadioButton("LAWANDS RADIO"));
        panel.add(new JRadioButton("DANIELS RADIO"));
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
