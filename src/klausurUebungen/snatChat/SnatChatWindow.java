package klausurUebungen.snatChat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class SnatChatWindow extends JFrame implements SnatChatFrontend {

    private SnatChatRoom room;
    private Account acc;
    private ChatMessagesComponent chats = new ChatMessagesComponent();
    private JRadioButton available, away, dnd;
    private JTextField msgField = new JTextField();
    private List<JLabel> messages = new ArrayList<>();

    public SnatChatWindow(SnatChatRoom room, Account account) {

        this.room = room;
        this.acc = account;

        buildUI();

    }

    private void buildUI() {
        setTitle(acc.getName() + " (" + room.getRoomName() + ")");
        setSize(400,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        JLabel name = new JLabel(acc.getName(), JLabel.CENTER);
        name.setForeground(acc.getColor());
        add(name, BorderLayout.NORTH);
        JPanel middlePanel = new JPanel();
        middlePanel.setLayout(new BorderLayout());
        middlePanel.add(chats, BorderLayout.CENTER);
        available = new JRadioButton("available");
        available.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendStateMessage(Account.State.AVAILABLE);
            }
        });
        away = new JRadioButton("away");
        away.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendStateMessage(Account.State.AWAY);
            }
        });
        dnd = new JRadioButton("Do not disturb");
        dnd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendStateMessage(Account.State.DND);
            }
        });
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(available);
        buttonGroup.add(away);
        buttonGroup.add(dnd);
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(available);
        buttonPanel.add(away);
        buttonPanel.add(dnd);
        middlePanel.add(buttonPanel, BorderLayout.SOUTH);
        add(middlePanel);
        setCorrectButtonState();
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new GridLayout(1,2,2,2));
        bottomPanel.add(msgField);
        JButton send = new JButton("Send");
        send.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(msgField.getText().isEmpty()) JOptionPane.showMessageDialog(middlePanel, "Dear " + acc.getName() + ", please enter a message");
                else {
                    Message msg = new Message(msgField.getText(), acc);
                    room.sendMessage(msg);
                    msgField.setText("");
                }
            }
        });
        msgField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(msgField.getText().isEmpty()) JOptionPane.showMessageDialog(middlePanel, "Dear " + acc.getName() + ", please enter a message");
                else {
                    Message msg = new Message(msgField.getText(), acc);
                    room.sendMessage(msg);
                    msgField.setText("");
                }
            }
        });
        bottomPanel.add(send);
        add(bottomPanel, BorderLayout.SOUTH);
        setVisible(true);
    }

    public void setMessageTime(String txt, int index){
        JLabel message = messages.get(index);
        message.setText(txt);
    }

    private void sendStateMessage(Account.State state) {
        room.sendMessage("State of user " + this.acc.getName() + "is now " + state.getDescription());
        this.acc.setState(state);
    }

    private void setCorrectButtonState() {
        switch (acc.getState()){
            case AWAY: away.setSelected(true); available.setSelected(false); dnd.setSelected(false);
            case AVAILABLE: away.setSelected(false); available.setSelected(true); dnd.setSelected(false);
            case DND: away.setSelected(false); available.setSelected(false); dnd.setSelected(true);
        }
    }

    @Override
    public void receiveMessage(Message msg) {
        JLabel message = new JLabel(msg.getAcc().getName() + ": " + msg.getTxt());
        message.setForeground(msg.getAcc().getColor());
        chats.add(message);
        messages.add(message);
        MessageThread messageThread = new MessageThread(this, msg.getTxt(), messages.indexOf(message));
        messageThread.start();
    }

    @Override
    public void receiveMessage(String txt) {
        JLabel message = new JLabel(txt);
        message.setForeground(Color.GRAY);
        chats.add(message);
        messages.add(message);
        MessageThread messageThread = new MessageThread(this, txt, messages.indexOf(message));
        messageThread.start();
    }

    @Override
    public Account getAccount() {
        return null;
    }

    public void removeMessage(int index) {
        chats.remove(messages.get(index));
    }
}
