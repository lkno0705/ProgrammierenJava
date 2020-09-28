package de.dhbwka.java.exercise.ui.paint;

import javax.swing.*;
import java.awt.*;

public class Election extends JComponent {

    public enum PARTIES{
        CDU(33.0, "CDU", Color.BLACK),
        SPD(20.5, "SPD", Color.RED),
        AFD(12.6, "AFD", Color.BLUE),
        FDP(10.7, "FDP", Color.YELLOW),
        LINKE(9.7, "Linke", Color.PINK),
        GRUENEN(8.9, "Die Grünen", Color.GREEN),
        DIE_UNWICHTIGEN_ASSIS(5.1, "Andere", Color.GRAY);


        public double perc;
        public String partieName;
        public Color color;

        PARTIES(double percent, String partieName, Color color){
            this.perc = percent;
            this.partieName = partieName;
            this.color = color;
        }

    }

    private double stringHeight(String text){
        return this.getFont().createGlyphVector(this.getFontMetrics(this.getFont()).getFontRenderContext(), text).getVisualBounds().getHeight();
    }

    private double stringWidth(String text){
        return this.getFontMetrics(this.getFont()).stringWidth(text);
    }

    @Override
    protected void paintComponent(Graphics g){

        int headerHeight = (int)(this.getHeight() * 0.1);
        int footerHeight = headerHeight * 3;
        int bodyHeight = this.getHeight() - headerHeight - footerHeight;

        //draw Header
        g.setColor(new Color(25, 25, 112));
        g.fillRect(0,0, this.getWidth(), headerHeight);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Helvetica", Font.BOLD, 15));
        g.drawString("Bundestagswahl 2017", 10,(int)((this.getHeight() * 0.1) / 2 + stringHeight("Bundestagswahl 2017") / 2));
        g.drawString("in %", (int)(this.getWidth() - stringWidth("in %") - 10), (int)((this.getHeight() * 0.1) / 2 + stringHeight("in %") / 2));

        //draw footer
        g.setColor(Color.WHITE);
        g.fillRect(0, (this.getHeight() - footerHeight), this.getWidth(), (this.getHeight() - footerHeight + headerHeight));
        g.setColor(new Color(121, 170, 211));
        g.fillRect(0, (this.getHeight() - footerHeight + headerHeight), this.getWidth(), this.getHeight());
        g.setColor(new Color(70,138, 194));
        g.fillRect(0, this.getHeight() - footerHeight + headerHeight, this.getWidth(), 3);
        g.fillRect(0, this.getHeight() - footerHeight + 2*headerHeight, this.getWidth(), 3);

        //draw Body
        g.setColor(new Color(121, 170, 211));
        g.fillRect(0,(int)(this.getHeight()*0.1), this.getWidth(), bodyHeight);
        g.setColor(Color.WHITE);
        for (int i = 1; i < 4; i++) {
            g.fillRect(0, (bodyHeight / 3) * i, this.getWidth(), 3);
        }
        double max = Double.NEGATIVE_INFINITY;
        for (PARTIES partie:PARTIES.values()
             ) {
                if(max<partie.perc) max = partie.perc;
        }

        int scale = (int)(bodyHeight / max);
        int columnWidth = this.getWidth() / PARTIES.values().length - 10;
        int XOff = 10 + columnWidth ;
        int i = 0;
        for (PARTIES partie:PARTIES.values()
             ) {
                g.setColor(partie.color);
                g.fillRect(i * XOff + 10, (bodyHeight + headerHeight), columnWidth, (int)(-(partie.perc * scale)));
                g.fillRect(i * XOff + 10, (int)(this.getHeight() - 2*headerHeight - (int)(headerHeight*0.2) - stringHeight(partie.partieName)), columnWidth, (int)(-(partie.perc * scale)));
                g.setColor(Color.BLACK);
                g.drawString(partie.partieName, i*XOff+10, (this.getHeight() - 2*headerHeight - (int)(headerHeight*0.1)));
                g.drawString(partie.perc + "%", i*XOff+10, (int)(this.getHeight()-headerHeight - headerHeight*0.1));
                i++;
        }

        // draw Seperationline
        g.setColor(new Color(62, 133, 192));
        g.fillRect(0, bodyHeight + headerHeight, this.getWidth(), (int)(headerHeight*0.2));

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setTitle("Election");
        frame.add(new Election());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(640,640);
        frame.setVisible(true);
    }

}



