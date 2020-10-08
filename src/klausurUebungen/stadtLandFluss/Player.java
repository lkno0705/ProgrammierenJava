package klausurUebungen.stadtLandFluss;

public class Player {

    private String name;
    private int score = 0;

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public Player(String name) {
        this.name = name;
    }
}
