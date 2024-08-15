package streamApi;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Streams {

    public static void main(String[] args) {
//        range & rangeclosed
        System.out.println("-------- range and rangeClosed");
        IntStream.range(1, 10)
                .forEach(s -> System.out.print(s + " "));
        System.out.println();
        IntStream.rangeClosed(1, 10)
                .forEach(s -> System.out.print(s + " "));
        System.out.println();
        System.out.println();

//        doWhile, dropWhile & takeWhile, skip and distinct
        System.out.println("-------- doWhile & takeWhile and skip");
        IntStream.iterate((int) 'A', i -> i <= (int) 'z', i -> i + 1)
                .filter(Character::isAlphabetic)
                .dropWhile(i -> Character.toUpperCase(i) <= 'C') //drops ABC
                .takeWhile(i -> i <= 'e')
                .skip(3) // skips DEF
                .forEach(e -> System.out.printf("%c ", e));
        System.out.println();
        System.out.println();

        Random random = new Random();
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

        int[] x = new int[]{1, 2};
        Stream<int[]> streamInt = Stream.of(x);
    }

    public static boolean isPrime(int number) {
        if (number <= 2) return number == 2;
        for (int divisor = 2; divisor < number; divisor++) {
            if (number % divisor == 0) return false;
        }
        return true;
    }
}
