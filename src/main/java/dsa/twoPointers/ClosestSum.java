package dsa.twoPointers;

import java.util.Arrays;

public class ClosestSum {
//    Given an integer array nums of length n and an integer target,
//    find three integers in nums such that the sum is closest to target.

//    Return the sum of the three integers.
//     Input: nums = [-1,2,1,-4], target = 1
//    Output: 2

    private static int solve(int[] nums, int target) {
//        Sort array for three pointers
        Arrays.sort(nums);
        int n = nums.length;
        int minDiff = Integer.MAX_VALUE;
        int ansSum = 0;
        for (int i = 0; i < n - 2; i++) {
            int j = i + 1;
            int k = n - 1;
            while (j < k) {
//                Calculate sum of three elements
                int sum = nums[i] + nums[j] + nums[k];
//                Calculate absolute difference from target
                int diff = Math.abs(sum - target);
//                Check if it is minimum difference and store sum
                if (diff < minDiff) {
                    minDiff = diff;
                    ansSum = sum;
                }
//                Move pointers
//                j++ if sum is less than target
//                k-- if sum is greater than target
                if (sum < target) j++;
                else k--;
            }
        }
        return ansSum;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 2, 1, -4};
        int target = 1;
        System.out.println(solve(nums, target));
    }

}
