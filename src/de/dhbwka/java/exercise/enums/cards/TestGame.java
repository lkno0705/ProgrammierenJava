package de.dhbwka.java.exercise.enums.cards;

public class TestGame {

    public static void main(String[] args) {
        CardGame game =  new CardGame();
        game.shuffle();
        for (int i = 0; i < 10; i++) {
            PlayingCard card = game.get();
            System.out.println(card.toString() + " | " + card.compareTo(new PlayingCard(PlayingCard.SUIT.HEART, PlayingCard.CARDVALUE.SEVEN)));
        }
        game.sort();
        for (PlayingCard card:
             game.all()) {
            System.out.println(card);
        }
    }

}
