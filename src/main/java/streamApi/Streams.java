package streamApi;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Streams {

    public static void main(String[] args) {
//        ******** Notes ********
//        Without terminal operation streams does not get executed

//        Collections to stream
        ArrayList<String> strList = new ArrayList<>(Arrays.asList("1a", "2b", "3c"));
        System.out.println("-------- Collections Stream");
        strList.stream().forEach(System.out::println);
        System.out.println();

//        Map To Stream    -> Map does not have a dedicated stream method
        Map<Character, int[]> bingoMap = new LinkedHashMap();
        int bingoIndex = 1;
        for (char c : "BINGO".toCharArray()) {
            int[] numbers = new int[15];
            int labelNo = bingoIndex;
            Arrays.setAll(numbers, i -> i + labelNo);
            bingoMap.put(c, numbers);
            bingoIndex += 15;
        }
        System.out.println("-------- Map Stream");
        bingoMap.entrySet()
                .stream()
                .map(e -> e.getKey() + " has range: " + e.getValue()[0] + " - "
                        + e.getValue()[e.getValue().length - 1])
                .forEach(System.out::println);
        System.out.println();

//        Arrays to stream
        String[] strArr = {"one", "two", "three"};
        System.out.print("-------- Arrays Stream & Stream.of(...values) : ");
        var stream1 = Arrays.stream(strArr).sorted(Comparator.reverseOrder());
//        Stream.of(...values)
        var stream2 = Stream.of("Six", "Five", "Four")
                .map(s -> s.toUpperCase());
//        Concat streamApi.Streams
        System.out.println("Concat streamApi.Streams");
        Stream.concat(stream2, stream1).forEach(System.out::println);
        System.out.println();

//        generate()
        System.out.println("-------- Stream.generate() takes a supplier and limit");
        Random random = new Random();
        IntStream.generate(() -> random.nextInt(2))
                .limit(10)
                .forEach(s -> System.out.print(s + " "));
        System.out.println();
        System.out.println();

//        iterate(seed, Unary)
        System.out.println("-------- Stream.iterate(seed, Unary)");
        System.out.println("First 20 prime numbers :");
        IntStream.iterate(1, n -> n + 1)
                .filter(Streams::isPrime)
                .limit(20)
                .forEach(s -> System.out.print(s + " "));
        System.out.println();
        System.out.println();

//      iterate(seed, Predicate Limit,  Unary)
        System.out.println("-------- Stream.iterate(seed, preicate, unary)");
        System.out.println("Prime numbers <= limit :");
        IntStream.iterate(1, n -> n <= 100, n -> n + 1)
                .filter(Streams::isPrime)
                .forEach(s -> System.out.print(s + " "));
        System.out.println();
        System.out.println();

//        range & rangeclosed
        System.out.println("-------- range and rangeClosed");
        IntStream.range(1, 10)
                .forEach(s -> System.out.print(s + " "));
        System.out.println();
        IntStream.rangeClosed(1, 10)
                .forEach(s -> System.out.print(s + " "));
        System.out.println();
        System.out.println();

//        doWhile & takeWhile and skip
        System.out.println("-------- doWhile & takeWhile and skip");
        IntStream.iterate((int) 'A', i -> i <= (int) 'z', i -> i + 1)
                .filter(Character::isAlphabetic)
                .dropWhile(i -> Character.toUpperCase(i) <= 'C')
                .takeWhile(i -> i <= 'e')
                .skip(3)
                .forEach(e -> System.out.printf("%c ", e));
        System.out.println();
        System.out.println();

        Random random1 = new Random();
        Stream.generate(() -> (char) ('A' + random.nextInt(26)))
                .limit(50)
                .distinct()
                .sorted()
                .forEach(d -> System.out.printf("%c ", d));
        System.out.println();
        System.out.println();


        System.out.println("------- Reduce and Max: Max in num array");
        List<Integer> numbers = Arrays.asList(1, 2, 4, 5, 7, 3, 2, 1, 15, 10, 8);
        numbers.stream().max((a, b) -> a >= b ? 1 : -1).ifPresent(e -> System.out.println("Maximum in list using max is: " + e));
        numbers.stream().reduce((a, b) -> a >= b ? a : b).ifPresent(e -> System.out.println("Maximum in list using reduce is: " + e));
        System.out.println();

        List<Student> students = new ArrayList<>(Arrays.asList(
                new Student(1, "USA", "Math", 17, 60),
                new Student(2, "IND", "Math", 24, 86),
                new Student(3, "AUS", "Math", 22, 35),
                new Student(4, "ENG", "Math", 45, 67),
                new Student(5, "PAK", "Math", 32, 75),
                new Student(6, "AUS", "Math", 42, 99),
                new Student(7, "ENG", "Math", 28, 78),
                new Student(8, "AUS", "Math", 29, 92),
                new Student(9, "GER", "Math", 21, 83),
                new Student(10, "IND", "Math", 40, 89)
        ));

        students.stream()
                .filter(s -> !s.getCountry().equals("IND") && !s.getCountry().equals("AUS"))
                .max(Comparator.comparingInt(Student::getMarks))
                .ifPresent(System.out::println);

        students.stream()
                .filter(s -> s.getAge() < 25)
                .max(Comparator.comparingInt(Student::getMarks))
                .ifPresent(System.out::println);
        System.out.println();

//        Summary statistics in IntStream, LongStream & DoubleStream
        System.out.println("--------- Summary Statistics");
        var summaryStats = students.stream()
                .mapToInt(Student::getAge)
                .distinct()
                .sorted()
                .summaryStatistics();
        System.out.println(summaryStats);
        System.out.println();

//        Stream to maps
        System.out.println("--------- Stream to Maps");
        System.out.println("Map of students in a country");
        var s2map = students.stream()
                .collect(Collectors.groupingBy(Student::getCountry));
        s2map.forEach((k, v) -> System.out.println(k + " ->  " + v.size()));
        System.out.println();

        System.out.println("Map of students in a country with age>=30 and marks>=70");
        var oldStudentSet = students.stream()
                .collect(Collectors.groupingBy(Student::getCountry,
                        Collectors.filtering(s -> s.getAge() >= 30 && s.getMarks() >= 70, Collectors.toList())
                ));
        oldStudentSet.forEach((k, v) -> System.out.println(k + " ->  " + v.size()));
        System.out.println();

        String countries = students.stream()
                .map(Student::getCountry)
                .collect(Collectors.joining(","));
        System.out.println("Countries: " + countries);
    }

    public static boolean isPrime(int number) {
        if (number <= 2) return number == 2;
        for (int divisor = 2; divisor < number; divisor++) {
            if (number % divisor == 0) return false;
        }
        return true;
    }
}
