package klausurUebungen.jbay;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;

public class BieterTerminal extends JFrame {

    private Bieter bieter;
    private Auktionshaus auktionshaus;
    private JLabel timeLabel = new JLabel(Calendar.getInstance().getTime().toString());
    private JPanel auctionPanel = new JPanel();


    public Bieter getBieter() {
        return bieter;
    }

    private class controllThread extends java.lang.Thread{
        @Override
        public void run() {
            while (true){

                timeLabel.setText(Calendar.getInstance().getTime().toString());
                repaint();
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public BieterTerminal(Bieter bieter, Auktionshaus auktionshaus) {
        this.bieter = bieter;
        this.auktionshaus = auktionshaus;
        auktionshaus.register(this);
        buildUI();
    }

    private void buildUI(){
        setTitle(bieter.getFullName());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 300);
        setLayout(new BorderLayout());

        add(timeLabel, BorderLayout.NORTH);
        controllThread controllThread = new controllThread();
        controllThread.start();
        drawPanel();
        add(auctionPanel);
        setVisible(true);
    }

    private void drawPanel(){
        auctionPanel = new JPanel();
        List<Auktion> auctions = auktionshaus.getAuktions();
        auctionPanel.setLayout(new GridLayout(auctions.size(), 5, 2,2));
        for (Auktion auction: auctions
        ) {
            auctionPanel.add(new JLabel(auction.getWare().getTitle()));
            auctionPanel.add(new JLabel(String.valueOf(auction.getPrice())));
            auctionPanel.add(new JLabel(auction.getGebot() != null ? auction.getGebot().getBieter().getFullName(): "---"));
            auctionPanel.add(new JLabel(auction.getEnd().toString()));
            JButton gebot = new JButton("Gebot");
            gebot.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(auction.getEnd().before(Calendar.getInstance())){
                        JOptionPane.showMessageDialog(null, "Die Aktion ist vorbei", "MELDUNG", JOptionPane.ERROR_MESSAGE);
                    }
                    else{
                        String input = (String) JOptionPane.showInputDialog("Bitte neues Gebot eingeben. \n Mindestens " + auction.getPrice());
                        try {
                            Gebot gebot1 = new Gebot(Double.parseDouble(input), bieter);
                            if(auction.gebotAbgeben(gebot1)){
                                JOptionPane.showMessageDialog(null, "Ihr Gebot wurde abgegeben", "MELDUNG", JOptionPane.INFORMATION_MESSAGE);
                                auktionshaus.updateTerminals();
                            }
                            else {
                                JOptionPane.showMessageDialog(null, "Ihr Gebot ist zu gering", "MELDUNG", JOptionPane.ERROR_MESSAGE);
                            }
                            log(gebot1, auction);
                        } catch (Exception exception){
                            JOptionPane.showMessageDialog(null, "Ihre Eingabe ist ungültig", "MELDUNG", JOptionPane.ERROR_MESSAGE);
                        }
                    }

                }
            });
            auctionPanel.add(gebot);
        }
    }

    public void updateTerminal(){
        remove(auctionPanel);
        drawPanel();
        add(auctionPanel);
    }

    private void log(Gebot g, Auktion auktion){
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("auktionen.txt", true));
            String stringBuilder = "[" + Calendar.getInstance().getTime().toString() + "] " +
                    "Gebot von " + g.getBieter().getFullName() + " " +
                    "für " + auktion.getWare().getTitle() + ": " +
                    g.getBetrag() + " Euro.\n";
            bufferedWriter.write(stringBuilder);
            bufferedWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
