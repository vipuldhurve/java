package dsa.sorting;

import java.util.Arrays;

public class LargestNumber {
//    Given a list of non-negative integers nums,
//    arrange them such that they form the largest number and return it.

//    Since the result may be very large,
//    so you need to return a string instead of an integer.

//    Input: nums = [10,2]
//    Output: "210"

//    Input: nums = [3,30,34,5,9]
//    Output: "9534330"

    // TIME COMPLEXITY: O(NlogN)
    private static String largestNumber(int[] nums) {
        int n = nums.length;

        // Convert integer array to string array
        String[] numStrs = new String[n];
        for (int i = 0; i < n; i++) numStrs[i] = String.valueOf(nums[i]);

        // Sort the strings using custom comparator
        Arrays.sort(numStrs, (a, b) -> (b + a).compareTo(a + b));

        // Edge case If the largest number is 0, return 0
        if (numStrs[0].equals("0")) return "0";

        // Concatenate the sorted array to form the largest number
        StringBuilder result = new StringBuilder();
        for (String s : numStrs) result.append(s);
        return result.toString();
    }

    public static void main(String[] args) {
        int[][] input = new int[][]{
                {10, 2},
                {3, 30, 34, 5, 9}
        };

        Arrays.stream(input)
                .peek(i -> System.out.println("ÏNPUT: " + Arrays.toString(i)))
                .map(LargestNumber::largestNumber)
                .forEach(o -> System.out.println("OUTPUT: " + o +"\n"));
    }
}

