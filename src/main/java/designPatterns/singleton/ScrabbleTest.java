package designPatterns.singleton;

import java.util.LinkedList;

public class ScrabbleTest {
    public static void main(String[] args) {
        Scrabble scrabble = Scrabble.getInstance();
        System.out.println("Scrabble: Id" + System.identityHashCode(scrabble));
        System.out.println(scrabble.getLetters());

        LinkedList<String> player1_Tiles = scrabble.getTiles(7);
        System.out.println("Player 1: " + player1_Tiles);
        System.out.println(scrabble.getLetters());

        Scrabble anotherScrabble = Scrabble.getInstance();
        System.out.println("Another Scrabble: Id" + System.identityHashCode(anotherScrabble));
        LinkedList<String> player2_Tiles = anotherScrabble.getTiles(7);
        System.out.println("player 2: "+ player2_Tiles);
    }
}
