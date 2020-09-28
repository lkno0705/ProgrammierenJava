package klausurUebungen.ui.event;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class NumberGuess extends JFrame {

    private class Player {
        private String name;
        private int score;

        public void setName(String name) {
            this.name = name;
        }

        public void setScore(int score) {
            this.score = score;
        }

        public int getScore() {
            return score;
        }

        public String getName() {
            return name;
        }

        public Player(String name, int score) {
            this.name = name;
            this.score = score;
        }
    }

    private JTextField nameField = new JTextField("Name");
    private JTextField numberField = new JTextField();
    private JTextField resultField = new JTextField();

    private int randomNumber = (int) (Math.random() * 1000);
    private int counter = 0;

    NumberGuess() {

        setFrame();
        add(generateTopPanel());
        JPanel bottomPanel = new JPanel();
        this.resultField.setPreferredSize(new Dimension(400, 16));
        bottomPanel.add(resultField);
        add(bottomPanel);
        setVisible(true);
    }

    private JPanel generateTopPanel() {
        JLabel name = new JLabel("Player Name");
        JLabel number = new JLabel("Enter number between 1 and 1000");

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));

        JPanel namePanel = new JPanel();
        namePanel.add(name);
        this.nameField.setPreferredSize(new Dimension(200, 16));
        namePanel.add(nameField);
        panel.add(namePanel);

        JPanel numberPanel = new JPanel();
        numberPanel.add(number);
        this.numberField.setPreferredSize(new Dimension(130, 16));
        this.numberField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    checkNumber();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
        numberPanel.add(numberField);
        panel.add(numberPanel);

        panel.add(generateButtonPanel());
        return panel;
    }

    private JPanel generateButtonPanel() {
        JPanel panel = new JPanel();

        JButton game = new JButton("New Game");
        game.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetGame();
            }
        });
        panel.add(game);

        JButton ok = new JButton("OK");
        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    checkNumber();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
        panel.add(ok);

        JButton best = new JButton("Best Player");
        best.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    bestPlayer();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
        panel.add(best);

        JButton exit = new JButton("Exit");
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        panel.add(exit);

        return panel;


    }

    private void resetGame() {
        this.nameField.setText("Enter Name");
        this.numberField.setText("");
        this.resultField.setText("");
        this.randomNumber = (int) (Math.random() * 1000);
        this.counter = 0;
    }

    private void bestPlayer() throws IOException {
        String fileContent = readFile();
        String[] scoreList;
        Player bestPlayer = new Player("", Integer.MAX_VALUE);
        Player[] players;

        scoreList = fileContent.split("\n");
        players = new Player[scoreList.length];
        for (int i = 0; i<scoreList.length; i++) {
            String player = scoreList[i];
            String playerName = player.split(":")[0];
            int score = Integer.parseInt(player.split(":")[1]);
            players[i] = new Player(playerName, score);
        }
        for (Player player:
             players) {
            int score = player.score;
            if ( score < bestPlayer.getScore()){
                bestPlayer.setScore(score);
                bestPlayer.setName(player.getName());
            }
        }
        this.resultField.setText("The best Player was: " + bestPlayer.getName() + " with " + bestPlayer.getScore() + " Attempts");
    }

    private void checkNumber() throws IOException {
        System.out.println(randomNumber);
        int playerNumber = Integer.parseInt(numberField.getText());
        counter++;
        if (playerNumber == randomNumber) {
            resultField.setText("You gessed correct and used " + counter + " Attempts");
            fileWrite();
        } else {
            String result = playerNumber < randomNumber ? "Attempt #" + counter + ": " + playerNumber + " => too small" : "Attempt #" + counter + ": " + playerNumber + " => too big";
            this.resultField.setText(result);
        }
    }

    private String readFile() throws IOException {
        File file = new File("scores.txt");
        StringBuilder content = new StringBuilder();
        if (!file.exists()) {
            file.createNewFile();
        } else {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file.getAbsolutePath()));
            String st;
            while ((st = bufferedReader.readLine()) != null) {
                content.append(st + "\n");
            }

        }
        return content.toString();
    }

    private void fileWrite() throws IOException {
        File file = new File("scores.txt");
        String playerName = nameField.getText();
        StringBuilder content = new StringBuilder();
        content.append(readFile());
        content.append(playerName + ":" + counter + "\n");
        FileWriter fileWriter = new FileWriter(file.getAbsolutePath());
        fileWriter.write(content.toString());
        fileWriter.close();
    }

    private void setFrame() {
        setName("Number Guessing Game");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(2, 1));
    }

    public static void main(String[] args) {
        NumberGuess a = new NumberGuess();
    }
}
