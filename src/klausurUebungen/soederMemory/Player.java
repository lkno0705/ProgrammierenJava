package klausurUebungen.soederMemory;

import java.awt.*;

public class Player {

    private String name;
    private int points;
    private PlayerStatus status;

    enum PlayerStatus {

        ACTIVE(Color.orange),
        WAITING(Color.black),
        FINISHED(Color.gray);

        Color color;

        PlayerStatus(Color color) {
            this.color = color;
        }
    }

    public Player(String s) {
        this.name = s;
        this.status = PlayerStatus.WAITING;
        this.points = 0;
    }

    public void addpoint(){
        this.points++;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void setStatus(PlayerStatus status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }

    public PlayerStatus getStatus() {
        return status;
    }
}
