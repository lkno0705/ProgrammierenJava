package klausurUebungen.jbay;

import java.util.Calendar;

public class Auktion {

    private Ware ware;
    private Gebot gebot = null;
    private double price = 0.0;
    private Calendar end = Calendar.getInstance();

    public Gebot getGebot() {
        return gebot;
    }

    public Ware getWare() {
        return ware;
    }

    public double getPrice() {
        return price;
    }

    public Calendar getEnd() {
        return end;
    }

    private final double increment = 1.0;

    public boolean gebotAbgeben(Gebot g) {

        if (g.getBetrag() < price + increment) return false;
        else if (gebot == null) {
            System.out.println("INITIAL");
            price = increment;
            gebot = g;
            return true;
        } else {


            if (gebot.getBieter() == g.getBieter() && gebot.getBetrag() < g.getBetrag()) {
                gebot = g;
            }
            if (g.getBetrag() >= price + increment) {
                if (g.getBetrag() > gebot.getBetrag()) {
                    price = gebot.getBetrag() + increment;
                    gebot = g;
                } else {
                    price = g.getBetrag() + increment;
                }
            }
            return true;
        }
    }

    public Auktion(Ware ware, int dauer) {
        this.ware = ware;
        end.setTimeInMillis(System.currentTimeMillis() + 60000 * dauer);
    }
}
