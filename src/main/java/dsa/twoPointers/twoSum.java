package dsa.twoPointers;

import java.util.Arrays;

public class twoSum {
//    Given an array of integers numbers that is sorted in non-decreasing order.

//    Return the indices (1-indexed) of two numbers, [index1, index2],
//    such that they add up to a given target number target and index1 < index2.
//    Note that index1 and index2 cannot be equal,
//    therefore you may not use the same element twice.

//    Input: numbers = [1,2,3,4], target = 3
//    Output: [1,2]

    private static int[] twoSumTwoPointerSolve(int[] nums, int target) {
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


    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        System.out.println("Input: " + Arrays.toString(nums) + " Output:" + Arrays.toString(twoSumTwoPointerSolve(nums, 5)));

//        nums = {1, 2, 3, 4, 5};
        System.out.println("Input: " + Arrays.toString(nums) + " Output:" + Arrays.toString(twoSumTwoPointerSolve(nums, 4)));

        nums = new int[]{};
        System.out.println("Input: " + Arrays.toString(nums) + " Output:" + Arrays.toString(twoSumTwoPointerSolve(nums, 4)));
    }
}
