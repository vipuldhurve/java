package dsa.mathAndGeometry;

import java.util.Arrays;

public class PlusOne {
//    You are given an integer array digits,
//    where each digits[i] is the ith digit of a large integer.
//    It is ordered from most significant to least significant digit,
//    and it will not contain any leading zero.

//    Return the digits of the given integer after incrementing it by one.

//    Input: [1,2,3,4]
//    Output: [1,2,3,5]

//    Input: [9,9,9]
//    Output: [1,0,0,0]

    private static int[] plusOne(int[] digits) {
        if (digits.length == 0) return digits;
//        Initializing carry as 1 to add 1 at last
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]+= 1;
            if (digits[i] < 9) {
                return digits;
            } else {
                digits[i] = 0;
            }
        }

        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

    public static void main(String[] args) {
        int[][] input = new int[][]{
                {1, 2, 3, 4},
                {9, 9, 9}
        };

        Arrays.stream(input)
                .peek(el -> System.out.println("Input:" + Arrays.toString(el)))
                .map(PlusOne::plusOne)
                .forEach(el -> System.out.println("Ouput: " + Arrays.toString(el) + "\n"));
    }
}
