package designPatterns.singleton;

import java.util.LinkedList;

public class ScrabbleThreadTest {
    private static class GetTheTiles implements Runnable{
        @Override
        public void run() {
            Scrabble scrabble = Scrabble.getInstance();
            System.out.println("Scrabble: Id" + System.identityHashCode(scrabble));
            System.out.println(scrabble.getLetters());

            LinkedList<String> player1_Tiles = scrabble.getTiles(7);
            System.out.println("Player 1: " + player1_Tiles);
            System.out.println("Got the tiles!");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Runnable getTiles = new GetTheTiles();
        Runnable getTilesAgain = new GetTheTiles();

        new Thread(getTiles).start();
        new Thread(getTilesAgain).start();
    }
}
