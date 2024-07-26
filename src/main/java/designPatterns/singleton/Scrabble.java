package designPatterns.singleton;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class Scrabble {
//    Eager initialization
//    private static Scrabble scrabble = new Scrabble();

//    Lazy initialization : if instance is required then only it is created
    private static Scrabble scrabble = null;

    private static final String[] scrabbleLetters = {"A", "A", "A", "A", "A", "A", "A",
            "A", "A", "B", "B", "C", "C", "D", "D", "D", "D", "E", "E", "E", "E", "E",
            "E", "E", "E", "E", "E", "E", "E", "F", "F", "G", "G", "G", "H", "H", "I",
            "I", "I", "I", "I", "I", "I", "I", "I", "J", "K", "L", "L", "L", "L", "M",
            "M", "N", "N", "N", "N", "N", "N", "O", "O", "O", "O", "O", "O", "O", "O",
            "P", "P", "Q", "R", "R", "R", "R", "R", "R", "S", "S", "S", "S", "T", "T",
            "T", "T", "T", "T", "U", "U", "U", "U", "V", "V", "W", "W", "X", "Y", "Y",
            "Z", "", ""};
    private final LinkedList<String> letters = new LinkedList<>(Arrays.asList(scrabbleLetters));

    private static boolean firstThread = true;

    private Scrabble() {
    }

    public static Scrabble getInstance() {
        if (scrabble == null) {
            if (firstThread) {
                firstThread = false;
                Thread.currentThread();
                try {
                    Thread.sleep(1000); // First Thread sleeping
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            //Thread safe singleton using synchronized block
            synchronized (Scrabble.class) {
                if (scrabble == null) {
                    scrabble = new Scrabble();
                    Collections.shuffle(scrabble.letters);
                }
            }

        }
        return scrabble;
    }

    public LinkedList<String> getLetters() {
        return scrabble.letters;
    }

    public LinkedList<String> getTiles(int howManyTiles) {
        LinkedList<String> tilesToSend = new LinkedList<>();
        for (int i = 0; i < howManyTiles; i++) {
            tilesToSend.add(letters.remove(0));
        }
        return tilesToSend;
    }

}
