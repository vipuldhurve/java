package streamApi.creation;

import streamApi.Streams;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamCreation {
//        Without terminal operation streams does not get executed

    public static void main(String[] args) {
//        ------------------ 1. Collections to stream
//        Using .stream()
        System.out.println("-------- 1. Collections to Stream : using .stream()");
        ArrayList<String> strList = new ArrayList<>(Arrays.asList("1a", "2b", "3c"));
        strList.stream()
                .forEach(el -> System.out.print(el + " "));
        System.out.println("\n");

//        ------------------- 2. Map To Stream
//        Map does not have a dedicated stream method
//        Using .entrySet().stream()
        System.out.println("-------- 2. Map to Stream : using .entrySet().stream()");
//        Using linkedHashMap to maintain order of keys BINGO
        Map<Character, int[]> bingoMap = new LinkedHashMap<>();
        int bingoIndex = 1;
        for (char c : "BINGO".toCharArray()) {
            int[] numbers = new int[15];
//            labelNo is effectively final here getting initialized from bingoIndex once in each scope
//            Each iteration creates a new scope for lambda making labelNo effectively final
            int labelNo = bingoIndex;
            Arrays.setAll(numbers, i -> i + labelNo);
            bingoMap.put(c, numbers);
            bingoIndex += 15;
        }
        bingoMap.entrySet()
                .stream()
                .map(e -> e.getKey() + " has range: " + e.getValue()[0] + " - "
                        + e.getValue()[e.getValue().length - 1])
                .forEach(System.out::println);
        System.out.println();

//        ------------------- 3. String to stream of characters
//        Using String.chars() to convert it to IntStream
        System.out.println("-------- 3. String to stream : using String.chars() to convert it to IntStream");
        String str = "hello";
        str.chars().forEach(c -> System.out.print((char) c + " "));
        System.out.println("\n");

//        ------------------- 4. Arrays to stream -> int, long, double and objects
//        Using Arrays.stream(arr[]) only
        System.out.println("-------- 4. Arrays to Stream : using Arrays.stream(arr[])");
        String[] strArr = {"one", "two", "three"};
        Arrays.stream(strArr)
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);
        System.out.println();

//        ------------------- 5. char[] to stream
//        Manual conversion: Using IntStream.range() and map()
        System.out.println("-------- 5. char[] to IntStream");
        System.out.println("Manually using IntStream.range() :");
        char[] charArr = {'a', 'b', 'c'};
        IntStream charIntStream = IntStream.range(0, charArr.length)
                .map(i -> charArr[i]);
        charIntStream.forEach(c -> System.out.print((char) c + " "));
        System.out.println();

//        Using new String(char[]).chars()
        System.out.println("Using new String(char[]).chars() :");
        new String(charArr).chars()
                .forEach(c -> System.out.print((char) c + " "));
        System.out.println("\n");

//        ------------------- 6. Stream.of(val1, val2, val3)
        System.out.println("-------- 6. Stream.of(object)");
//        Note here that it returns Stream<Integer> i.e. objects
//        Java automatically converts (auto-boxes) each int into an Integer
//        This results in Stream.of(1, 2, 3) being interpreted as Stream.of(Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3))
        Stream<Integer> streamInt = Stream.of(1, 2, 3);
        streamInt
                .forEach(e -> System.out.print(e + " "));
        System.out.println();

        System.out.println("-------- Stream.of(object[])");
        String[] strArray = new String[]{"four", "five", "six"};
        Stream.of(strArray)
                .map(String::toUpperCase)
                .forEach(e -> System.out.print(e + " "));
        System.out.println();

        System.out.println("-------- Stream.of(primitive[])");
        int[] intArr = new int[]{1, 2, 3};
//        Note here that it returns Stream<int[]> and not Stream<Integers>
        Stream<int[]> streamIntArr = Stream.of(intArr);
        streamIntArr
                .forEach(System.out::println);
        System.out.println();


//        ------------------- 7. IntStream.generate(supplier)
//        use .limit() for finite
        System.out.println("-------- 7. IntStream.generate() takes a supplier producing infinite stream");
        Random random = new Random();
        IntStream.generate(() -> random.nextInt(2))
                .limit(10)
                .forEach(e -> System.out.print(e + " "));
        System.out.println("\n");

//        ------------------- 7. IntStream.iterate(seed, Unary)
//        use .limit() for finite
//        iterate(seed, Unary)
        System.out.println("-------- 7. Stream.iterate()");
        System.out.println("iterate(seed, unary) First 20 prime numbers :");
        IntStream.iterate(1, i -> i + 1)
                .filter(Streams::isPrime)
                .limit(20)
                .forEach(e -> System.out.print(e + " "));
        System.out.println("\n");

//        iterate(seed, predicate, unary)
        System.out.println("iterate(seed, predicate, unary) prime numbers <= 100 :");
        IntStream.iterate(1, n -> n <= 100, n -> n + 1)
                .filter(Streams::isPrime)
                .forEach(e -> System.out.print(e + " "));
        System.out.println("\n");


//        ------------------- 8. Concat Stream.concat()
        System.out.println("Concat streams Streams.concat()");
        Stream<Character> stream1 = Stream.of('a', 'b', 'c');
        Stream<Character> stream2 = Stream.of('x', 'y', 'z');
        Stream.concat(stream1, stream2)
                .forEach(e -> System.out.print(e + " "));
        System.out.println();
    }
}
