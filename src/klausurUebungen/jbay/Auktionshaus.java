package klausurUebungen.jbay;

import java.util.LinkedList;
import java.util.List;

public class Auktionshaus {

    private List<BieterTerminal> bieterTerminals = new LinkedList<>();
    private List<Auktion> auktions = new LinkedList<>();

    public void addAuktion(Auktion a){
        auktions.add(a);
    }

    public void removeAuktion(Auktion a){
        auktions.remove(a);
    }

    public List<Auktion> getAuktions() {
        return auktions;
    }

    public void register(BieterTerminal bt){
        bieterTerminals.add(bt);
    }

    public void unregister(BieterTerminal bt){
        bieterTerminals.remove(bt);
    }

    public void updateTerminals(){
        for (BieterTerminal bieterTerminal: bieterTerminals) {
            bieterTerminal.updateTerminal();
        }
    }


}
