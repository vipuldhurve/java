package dsa.slidingWindow.variable;

import java.util.Arrays;

public class LargestArrayOfSumK {

//    Given an array arr containing n integers and an integer k.
//    find the length of the longest Sub-Array with the sum of the elements
//    equal to the given value k

//    Input : arr[] = {10, 5, 2, 7, 1, 9}, k = 15
//    Output : 4

//    Input : arr[] = {-1, 2, 3}, k = 6
//    Output : 0


    public static int[] largestArrayOfSumK(int[] nums, int sum) {
        int left = 0;
        int right = 0;
        int currSum = 0;
        int i = 0;
        int j = 0;
        while (right < nums.length) {
            currSum += nums[right];

            if (currSum == sum) {
                if (right - left > j - i) {
                    i = left;
                    j = right;
                }
            } else {
                while (currSum > sum && left <= right) {
                    currSum -= nums[left];
                    left++;
                }
//                Check possibility of answer if currSum equals sum
                if (currSum == sum && (right - left) > (j - i)) {
                    i = left;
                    j = right;
                }
            }
//            Otherwise increasing window size (also in case of currSum < sum)
            right++;
        }
        if (j == i) return new int[0];
        int[] ans = new int[j - i + 1];
        for (int x = i, y = 0; x <= j; x++, y++) ans[y] = nums[x];
        return ans;
    }

    private static void solve(int[] nums, int sum) {
        System.out.println("Input: " + Arrays.toString(nums) + " sum = " + sum);
        System.out.println("Output: " + Arrays.toString(largestArrayOfSumK(nums, sum)) + "\n");
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4, 1, 1, 1, 2, 3, 5};
        int sum = 5;
        solve(nums, sum);

        nums = new int[]{10, 5, 2, 7, 1, 9};
        sum = 15;
        solve(nums, sum);

        nums = new int[]{-1, 2, 3};
        sum = 6;
        solve(nums, sum);
    }
}
