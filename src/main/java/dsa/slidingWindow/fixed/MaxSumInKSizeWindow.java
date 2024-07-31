package dsa.slidingWindow.fixed;

import java.util.Arrays;

public class MaxSumInKSizeWindow {

//    All integers in array are positive
//    Given an array of integers and a number k
//    find the maximum sum of a subarray of size k.

//    Input  : arr[] = {100, 200, 300, 400},  k = 2
//    Output : 700

//    Input  : arr[] = {1, 4, 2, 10, 23, 3, 1, 0, 20}, k = 4
//    Output : 39

//    Input  : arr[] = {2, 3}, k = 3
//    Output : Invalid

    public static int maxSumInKSizeWindow(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int maxSum = 0;
        int sum = 0;
        while (right < nums.length) {
            sum = sum + nums[right];
            if (right - left + 1 < k) {
                right++;
            } else if (right - left + 1 == k) {
                maxSum = Math.max(sum, maxSum);
                sum = sum - nums[left];
                left++;
                right++;
            }
        }
        return maxSum;
    }

    private static void solve(int[] nums, int k) {
        System.out.println("Input: " + Arrays.toString(nums) + " k = " + k);
        System.out.println("Maximum sum in window size k : " + maxSumInKSizeWindow(nums, k) + "\n");
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 5, 1, 8, 2, 9, 1};
        int k = 3;
        solve(nums, k);

        nums = new int[]{100, 200, 300, 400};
        k = 2;
        solve(nums, k);

        nums = new int[]{2, 3};
        k = 3;
        solve(nums, k);
    }
}
