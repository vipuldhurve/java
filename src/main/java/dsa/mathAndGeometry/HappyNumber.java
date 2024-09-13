package dsa.mathAndGeometry;

import java.util.Arrays;

public class HappyNumber {

//    Write an traversal to determine if a number n is happy.
//    A happy number is a number defined by the following process:

//    1. Starting with any positive integer,
//    replace the number by the sum of the squares of its digits.

//    2. Repeat the process until the number equals 1 (where it will stay),
//    or it loops endlessly in a cycle which does not include 1.

//    3. Those numbers for which this process ends in 1 are happy.

//    Return true if n is a happy number, and false if not.

    private static int squareSum(int val) {
        int sum = 0;
        while (val > 0) {
            int rem = val % 10;
            sum += (rem * rem);
            val /= 10;
        }
        return sum;
    }

//    Approach 1:
//    Either squareSum will end at 1
//    or squareSum will keep revolving around 4
    private static boolean isHappyNumber1(int val) {
        while (val != 1 && val != 4) val = squareSum(val);
        if (val == 1) return true;
        return false;
    }

//    Approach 2: Using slow and fast pointer
//    Either squareSum will become 1
//    Or squareSum will meet at some circular point
    private static boolean isHappyNumber2(int val) {
        int slow = val, fast = val;
        do {
            slow = squareSum(slow);
            fast = squareSum(squareSum(fast));
        } while (fast != slow);
        return slow == 1;
    }

    public static void main(String[] args) {
        int[] input = new int[]{19, 101, 100, 2};
        Arrays.stream(input)
                .peek(el -> System.out.println("Input: " + el))
                .mapToObj(HappyNumber::isHappyNumber2)
                .forEach(el -> System.out.println("Is Happy Number: " + el + "\n"));
    }
}
