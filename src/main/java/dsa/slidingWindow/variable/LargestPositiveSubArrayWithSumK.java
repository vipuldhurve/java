package dsa.slidingWindow.variable;

import java.util.Arrays;

public class LargestPositiveSubArrayWithSumK {
//    Array has POSITIVE INTEGERS ONLY!!!

//    Given an array arr containing n NON-NEGATIVE integers and an integer k.
//    find the length of the longest Sub-Array with the sum of the elements
//    equal to the given value k

//    Input : arr[] = {10, 5, 2, 7, 1, 9}, k = 15
//    Output : 4

//    Input : arr[] = {1, 2, 3}, k = 6
//    Output : 0

    //    TIME COMPLEXITY: O(N)   |   SPACE COMPLEXITY: O(1)
    public static int[] largestArrayOfSumK(int[] nums, int sum) {
        int left = 0;
        int right = 0;
        int currSum = 0;
        int start = -1;
        int end = -1;
        while (right < nums.length) {
            currSum += nums[right];

            if (currSum == sum) {
                if (right - left > end - start) {
                    start = left;
                    end = right;
                }
            } else {
                while (currSum > sum && left <= right) {
                    currSum -= nums[left];
                    left++;
                }
//                Check possibility of answer if currSum equals sum
                if (currSum == sum && (right - left) > (end - start)) {
                    start = left;
                    end = right;
                }
            }
//            Otherwise increasing window size (also in case of currSum < sum)
            right++;
        }
//        Copy and return sub array
        if (start == -1 && end == -1) return new int[0];
        int[] ans = Arrays.copyOfRange(nums, start, end + 1);
        ;
        return ans;
    }

    private static void solve(int[] nums, int sum) {
        System.out.println("INPUT: " + Arrays.toString(nums) + " sum = " + sum);
        System.out.println("OUTPUT: " + Arrays.toString(largestArrayOfSumK(nums, sum)) + "\n");
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4, 1, 1, 1, 2, 3, 5};
        int sum = 5;
        solve(nums, sum);

        nums = new int[]{10, 5, 2, 7, 1, 9};
        sum = 15;
        solve(nums, sum);

//        Q) THIS APPROACH WILL FAIL WITH NEGATIVE NUMBERS in the array?
//        A) YES
        nums = new int[]{4, 1, 1, -2, 1};
        sum = 5;
        solve(nums, sum);
//        POSITIVE CASE
//        Because let's say in the given array [4,1,1,1,2,3,5]
//        when we found the sum within the window to be greater than the desired value 5
//        (i=0, j=2 -> [4,1,1]), we started reducing the size of the window by doing i++.
//        Here we assumed that once the sum of elements within the window becomes greater than 5
//        then increasing the window size will just add to the sum
//        and hence we will not attain the sum 5 again.
//        This is true when all the element are positive and hence reducing the window size by doing i++ makes sense.

//        NEGATIVE CASE
//        But this might not be true if array also contains negative numbers.
//        Consider the array [4,1,1,-2,1,5],
//        here we would have found the sum to be greater than 5 for i=0, j=2
//        and if we would have now started reducing the window size by doing i++,
//        we would have missed the potential subarray (i=0, j=4).
//        In short, the discussed approach will not work with array having negative numbers.
    }
}
