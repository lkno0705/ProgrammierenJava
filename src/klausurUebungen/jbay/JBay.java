package klausurUebungen.jbay;

public class JBay {

    public static void main(String[] args) {
        Auktionshaus jbay = new Auktionshaus();
        jbay.addAuktion(new Auktion(
                new Ware("Turnschuhe", "Tolle Turnschuhe, kaum getragen"), 2
        ));
        jbay.addAuktion(new Auktion(
                new Ware("iPad", "Nagelneues iPad pro"), 4
        ));
        jbay.addAuktion(new Auktion(
                new Ware("CurryWurst", "Scharf, ohne Pommes"), 5
        ));
        BieterTerminal bieterTerminal1 = new BieterTerminal(new Bieter("Leon", "Knorr"), jbay);
        jbay.register(bieterTerminal1);
        BieterTerminal bieterTerminal2 = new BieterTerminal(new Bieter("Andreas", "Burger"), jbay);
        jbay.register(bieterTerminal2);
    }

}
