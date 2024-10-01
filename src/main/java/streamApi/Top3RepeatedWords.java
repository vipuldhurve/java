package streamApi;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Top3RepeatedWords {
//    To find the top 3 most repeated words in a list of strings using Java Streams,
//    we can break the problem into the following steps:

//    1). Flatten the List of Strings into a Stream of Words:
//    Split each string into individual words.

//    2). Count the Frequency of Each Word:
//    Use a Map<String, Long> to store the frequency of each word.

//    3). Sort the Words by Frequency:
//    Sort the map entries by value (frequency) in descending order.

//    4). Extract the Top 3 Words:
//    Limit the stream to the top 3 most frequent words

    public static void main(String[] args) {
        List<String> sentences = Arrays.asList(
                "apple orange banana apple guava",
                "banana apple banana orange guava",
                "orange banana guava apple orange",
                "banana apple guava orange banana"
        );
        // Find top 3 most repeated words
        sentences.stream()
                // Split each sentence into words and flatten into a stream of words
                .flatMap(sentence -> Arrays.stream(sentence.split(" ")))
                // Collect words and count their occurrences
                .collect(Collectors.groupingBy(word -> word, Collectors.counting()))
                .entrySet().stream()
                // Sort by frequency in descending order
                .sorted((e1, e2) -> Long.compare(e2.getValue(), e1.getValue()))
                // Limit to top 3 entries
                .limit(3)
                // Collect or print the top 3 entries
                .forEach(e -> System.out.println(e.getKey() + " : " + e.getValue()));
//                .collect(Collectors.toList());
    }
}
