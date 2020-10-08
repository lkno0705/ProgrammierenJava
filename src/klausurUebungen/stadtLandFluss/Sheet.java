package klausurUebungen.stadtLandFluss;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Sheet extends JFrame {

    private JLabel score = new JLabel("0");
    private JLabel remainingSeconds = new JLabel();
    private JLabel letter = new JLabel();
    private JPanel center = new JPanel();
    private JButton startButton = new JButton("Start");
    JButton stopButton = new JButton("Stop");

    public Sheet(Player player, Game game) {

        setTitle(player.getName());
        setLayout(new BorderLayout());
        JPanel top = new JPanel();
        top.setLayout(new GridLayout(3,3,2,2));
        top.add(new JLabel("Punkte"));
        top.add(score);
        top.add(new JLabel());
        top.add(new JLabel("verbleibende Sekunden"));
        top.add(remainingSeconds);
        top.add(new JLabel());
        top.add(new JLabel("Anfangsbuchstabe"));
        top.add(letter);
        top.add(new JLabel());
        this.add(top, BorderLayout.NORTH);

        center.add(new JLabel("Kein Spiel aktiv"));
        this.add(center, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();

        startButton.setEnabled(true);
        buttonPanel.add(startButton);
        buttonPanel.add(stopButton);
        this.add(buttonPanel, BorderLayout.SOUTH);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 400);
        this.setVisible(true);

    }

    public void displayStop() {

        // TODO: display results
        this.startButton.setEnabled(false);
        this.stopButton.setEnabled(true);
    }

    public HashMap<Game.ColumnType, String> getAnswers() {
        HashMap<Game.ColumnType, String> answers = new HashMap<>();
        return answers;
    }
}
