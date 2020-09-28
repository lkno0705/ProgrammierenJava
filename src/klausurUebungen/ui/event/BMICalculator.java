package klausurUebungen.ui.event;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BMICalculator extends JFrame {

    private enum FEMALETABLE {
        UNDERWEIGHT(0, 18, "Untergewicht"),
        NORMALWEIGHT(19,24,"Normalgewicht"),
        OVERWEIGHT(24,30,"Übergewicht"),
        ADIPOSITAS(30,40, "Adipositas"),
        MASSIVEADIPOSITAS(40, Integer.MAX_VALUE, "Massive Adipositas");

        public int lowerBound;
        public int upperBound;
        public String description;

        public static String checkTable(float bmi){
            MALETABLE[] weights = MALETABLE.values();
            for (MALETABLE weight : weights) {
                if (weight.lowerBound < bmi && weight.upperBound >= bmi) {
                    return weight.description;
                }
            }
            return "UNDEFINED";
        }

        FEMALETABLE(int lowerBound, int upperBound, String description) {
            this.lowerBound = lowerBound;
            this.upperBound = upperBound;
            this.description = description;
        }
    }

    private enum MALETABLE {
        UNDERWEIGHT(0, 19, "Untergewicht"),
        NORMALWEIGHT(20,25,"Normalgewicht"),
        OVERWEIGHT(25,30,"Übergewicht"),
        ADIPOSITAS(30,40, "Adipositas"),
        MASSIVEADIPOSITAS(40, Integer.MAX_VALUE, "Massive Adipositas");

        public int lowerBound;
        public int upperBound;
        public String description;

        public static String checkTable(float bmi){
            MALETABLE[] weights = MALETABLE.values();
            for (MALETABLE weight : weights) {
                if ((float) (weight.lowerBound) < bmi && (float) (weight.upperBound) >= bmi) {
                    return weight.description;
                }
            }
            return "UNDEFINED";
        }

        MALETABLE(int lowerBound, int upperBound, String description) {
            this.lowerBound = lowerBound;
            this.upperBound = upperBound;
            this.description = description;
        }
    }

    private enum EXCEPTIONS {
        NumberFormatException("This Exceptions is caused by a Wrong input in a Textfield, where a number should be entered.");

        public String description;

        EXCEPTIONS(String description) {
            this.description = description;
        }
    }

    private class Exception {
        boolean value;
        String type;
        String description;

        public Exception(boolean value, String type) {
            this.value = value;
            this.type = type;
            this.description = EXCEPTIONS.valueOf(type).description;
        }

        public void reset() {
            this.value = false;
            this.type = "";
            this.description = "";
        }

    }

    JLabel weightLabel;
    JLabel heightLabel;
    JLabel bmiLabel;

    JRadioButton male;
    JRadioButton female;

    JButton calculate;

    JTextField weightTextField;
    JTextField heightTextField;
    JTextField bmiTextField;
    JTextField response;

    Exception exception;

    BMICalculator() {
        initVariables();
        generateHandlers();
        buildWindow();
    }

    private void initVariables() {
        this.weightLabel = new JLabel("Weight [kg]: ");
        this.heightLabel = new JLabel("Body height [m]: ");
        this.bmiLabel = new JLabel("BMI: ");

        this.male = new JRadioButton("male");
        this.female = new JRadioButton("female");

        this.calculate = new JButton("calculate");

        this.weightTextField = new JTextField("");
        this.heightTextField = new JTextField("");
        this.bmiTextField = new JTextField("");
        this.bmiTextField.setEnabled(false);
        this.response = new JTextField("");
        this.response.setEnabled(false);
    }

    private void generateHandlers() {

        this.calculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                float weight = castValue(weightTextField.getText());
                float height = castValue(heightTextField.getText());
                try {
                    if (exception.value) {
                        JOptionPane.showMessageDialog(
                                null,
                                "A " + exception.type + " Occured; \n " + exception.description,
                                exception.type,
                                JOptionPane.ERROR_MESSAGE
                        );
                        exception.reset();
                    }
                    else calculateAndSetValues(weight, height);
                }catch(java.lang.Exception exception ){
                    calculateAndSetValues(weight, height);
                }
            }
        });

    }

    private void calculateAndSetValues(float weight, float height){
        float bmiValue = (float) (weight / Math.pow(height, 2));
        bmiTextField.setText(String.valueOf(bmiValue));
        if (male.isSelected()) {
            response.setText(MALETABLE.checkTable(bmiValue));
        }
        else response.setText(FEMALETABLE.checkTable(bmiValue));
    }

    private float castValue(String input) {
        try {
            return Float.parseFloat(input);
        } catch (NumberFormatException numberFormatException) {
            this.exception = new Exception(true, "NumberFormatException");
            return 0;
        }
    }

    private void buildWindow() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 400);
        this.setLayout(new GridLayout(4, 1, 5, 5));

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(this.male);
        buttonGroup.add(this.female);

        JPanel upperPanel = new JPanel();
        JPanel bmi = new JPanel();

        upperPanel.setLayout(new GridLayout(3, 2, 2, 2));
        bmi.setLayout(new GridLayout(1, 2));

        upperPanel.add(this.weightLabel);
        upperPanel.add(this.weightTextField);
        upperPanel.add(this.heightLabel);
        upperPanel.add(this.heightTextField);
        upperPanel.add(this.male);
        upperPanel.add(this.female);

        bmi.add(bmiLabel);
        bmi.add(bmiTextField);

        add(upperPanel);
        add(calculate);
        add(bmi);
        add(response);

        setVisible(true);
    }

    public static void main(String[] args) {
        BMICalculator a = new BMICalculator();
    }
}
