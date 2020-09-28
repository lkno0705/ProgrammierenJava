package de.dhbwka.java.exercise.enums.cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CardGame {

    public List<PlayingCard> stack = new ArrayList<>();

    CardGame(){
        for (PlayingCard.SUIT suit:
                PlayingCard.SUIT.values()) {
            for (PlayingCard.CARDVALUE value:
                 PlayingCard.CARDVALUE.values()) {
                this.stack.add(new PlayingCard(suit, value));
            }
        }
    }

    void shuffle(){
        Collections.shuffle(this.stack);
    }

    void sort(){
        Collections.sort(this.stack);
    }

    PlayingCard get(){
        return this.stack.remove(0);
    }

    List<PlayingCard> all(){
        return this.stack;
    }

}
