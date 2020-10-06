package klausurUebungen.soederMemory;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class MemoryGame {

    private int rows, cols;
    private List<Player> players;
    private Set<MemoryImages.MemoryImage> memoryImages = new HashSet<>();
    private Player activePlayer;

    public MemoryGame(List<Player> players, List<MemoryImages.MemoryImage> images, int rows, int cols) throws MemoryException {

        int pictureCount = (rows * cols + 1) / 2;


        if (players.size() >= 2) throw new MemoryException(MemoryException.MemoryExceptions.PLAYERS);

        else if (!(images.size() > pictureCount)) throw new MemoryException(MemoryException.MemoryExceptions.IMAGES);

        while (memoryImages.size() <= pictureCount){
            memoryImages.add(images.get(new Random().nextInt(memoryImages.size())));
        }
        this.players = players;
        this.rows = rows;
        this.cols = cols;
    }

    public Player getCurrentPlayer() {
        return activePlayer;
    }

    public boolean isBlankRequired(){
        return rows * cols % 2 != 0;
    }

    public void nextPlayer(){
        int activePlayerIndex = players.indexOf(activePlayer);
        int index = activePlayerIndex + 1 > players.size() ? 0 : activePlayerIndex;
        activePlayer.setStatus(Player.PlayerStatus.WAITING);
        players.set(activePlayerIndex, activePlayer);
        this.activePlayer = players.get(index);
        players.get(index).setStatus(Player.PlayerStatus.ACTIVE);
        activePlayer.setStatus(Player.PlayerStatus.ACTIVE);
    }
}
