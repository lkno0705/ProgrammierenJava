package klausurUebungen.snatChat;

import java.awt.*;
import java.util.Random;

public class Account {

    private String name;
    private State state;
    private Color color;

    enum State {
        AVAILABLE("Available"),
        AWAY("Away"),
        DND("Do not disturb");

        private String description;

        State(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public State getState() {
        return state;
    }

    public Color getColor() {
        return color;
    }

    public Account(String name) {
        this.name = name;
        Random rnd = new Random();
        this.color = new Color(rnd.nextInt(201), rnd.nextInt(201), rnd.nextInt(201));
        this.state = State.AVAILABLE;
    }
}
