package dsa.twoPointers;

import java.lang.reflect.Array;
import java.util.Arrays;

public class twoSum {
//    Given an array of integers numbers that is sorted in non-decreasing order.

//    Return the indices (1-indexed) of two numbers, [index1, index2],
//    such that they add up to a given target number target and index1 < index2.
//    Note that index1 and index2 cannot be equal,
//    therefore you may not use the same element twice.

//    Input: numbers = [1,2,3,4], target = 3
//    Output: [1,2]

    //    TIME COMPLEXITY: O(N) as input array is already sorted
    //    SPACE COMPLEXITY: O(1)
    private static int[] twoSumViaTwoPointer(int[] nums, int target) {
        int[] result = {-1, -1};
        if (nums == null || nums.length <= 1) return result;

        int left = 0, right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                result[0] = left;
                result[1] = right;
                break;
            } else if (sum < target) left++;
            else {
                right--;
            }
        }
        return result;
    }

    private static void solve(int[] input, int target) {
        System.out.println("INPUT: " + Arrays.toString(input) + "  TARGET = " + target);
        System.out.println("OUTPUT: " + Arrays.toString(twoSumViaTwoPointer(input, target)) + "\n");
    }


    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4, 5};
        int target = 5;
        solve(input, target);

//        nums = {1, 2, 3, 4, 5};
        target = 4;
        solve(input, target);

        input = new int[]{};
        target = 5;
        solve(input, target);
    }
}
