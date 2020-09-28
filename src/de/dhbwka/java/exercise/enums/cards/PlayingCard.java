package de.dhbwka.java.exercise.enums.cards;

public class PlayingCard implements Comparable<PlayingCard> {


    public enum SUIT{
        DIAMONDS,
        HEART,
        SPADE,
        CLUBS
    }

    public enum CARDVALUE{
        SEVEN,
        EIGHT,
        NINE,
        JACK,
        QUEEN,
        KING,
        TEN,
        ACE
    }

    private SUIT suit;
    private CARDVALUE cardvalue;

    PlayingCard(SUIT suit, CARDVALUE cardvalue){
        this.suit = suit;
        this.cardvalue = cardvalue;
    }

    @Override
    public String toString() {
        return "PlayingCard{" +
                "suit=" + suit +
                ", cardvalue=" + cardvalue +
                '}';
    }

    @Override
    public int compareTo(PlayingCard o) {
        if(PlayingCard.this.suit.ordinal() > o.suit.ordinal()) return 1;
        else if (PlayingCard.this.suit.ordinal() == o.suit.ordinal()){
            if (PlayingCard.this.cardvalue.ordinal() == o.cardvalue.ordinal()) return 0;
            else if(PlayingCard.this.cardvalue.ordinal() > o.cardvalue.ordinal()) return 1;
            else return -1;
        }
        else return -1;
    }

}
