package dsa.mathAndGeometry;

import java.util.Arrays;

public class RotateArray {
//    Given an integer array nums, rotate the array to the right by k steps,
//    where k is non-negative.

//    Example 1:
//    Input: nums = [1,2,3,4,5,6,7], k = 3
//    Output: [5,6,7,1,2,3,4]
//    Explanation:
//    rotate 1 steps to the right: [7,1,2,3,4,5,6]
//    rotate 2 steps to the right: [6,7,1,2,3,4,5]
//    rotate 3 steps to the right: [5,6,7,1,2,3,4]

//    Example 2:
//    Input: nums = [-1,-100,3,99], k = 2
//    Output: [3,99,-1,-100]

    //  Solution1:  Time complexity: O(N) | Space complexity: O(N)
    private static void rotateArray1(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        if (k == 0) return;
        int[] rotated = new int[n];
//        1 2 3 4 5 6 7  ,  k=3
//        5 6 7 1 2 3 4
//        ith element will go to (i+k)%n th position
        for (int i = 0; i < n; i++) {
            rotated[(i + k) % n] = nums[i];
        }

        for (int i = 0; i < n; i++) {
            nums[i] = rotated[i];
        }
    }

    //  Solution2:  Time complexity: O(N) | Space complexity: O(N)
    private static void rotateArray2(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        if (k == 0) return;
//                         k
//        i       :  0 1 2 3 4 5 6
//                   # # # # * * *
//        nums    :  1 2 3 4 5 6 7  ,  k=3
//        ________________________
//                   * * * # # # #
//        rotated :  5 6 7 1 2 3 4

//          values from (K+1, n-1) + values (0, k)

        int[] rotated = new int[n];
        System.arraycopy(nums, n - k, rotated, 0, k);
        System.arraycopy(nums, 0, rotated, k, n - k);
        System.arraycopy(rotated, 0, nums, 0, n);
    }

    //   Solution3: Time complexity: O(N) | Space complexity: O(1)
    private static void rotateArray3(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        if (k == 0) return;
//                         k
//        i       :  0 1 2 3 4 5 6
//                   # # # # * * *
//        nums    :  1 2 3 4 5 6 7  ,  k=3
//        ________________________
//        1). reverse complete array -> (0 to n-1)
//                   * * * # # # #
//        nums    :  7 6 5 4 3 2 1
//        2). reverse from -> (0 to k-1) and -> (k+1 to n-1)
//        nums    :  5 6 7 1 2 3 4
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    private static void reverse(int[] nums, int start, int end) {
//         Reversing Sub-array without using temp(extra variable)
        while (start < end) {
            nums[start] = nums[start] + nums[end];
            nums[end] = nums[start] - nums[end];
            nums[start] = nums[start] - nums[end];
            start++;
            end--;
        }
//        NOTE: Be careful! It can produce incorrect results if start == end
//        Example: If (start == end), nums[start] = nums[end] = 5
//        step 1: nums[start] = start(5) + end(5) = 10
//        because start == end, nums[end] will also be 10
//        step 2: nums[end] = start(10) - end(10) = 0
//        step 3: nums[start] = start(0) - end(0) = 0
    }

    public static void main(String[] args) {
        int[] input = new int[]{1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        System.out.println("INPUT: " + Arrays.toString(input));
        rotateArray1(input, k);
        System.out.println("OUTPUT: " + Arrays.toString(input) + "\n");

        input = new int[]{99, -1, -100, 3};
        k = 2;
        System.out.println("INPUT: " + Arrays.toString(input));
        rotateArray2(input, 2);
        System.out.println("OUTPUT: " + Arrays.toString(input) + "\n");

        input = new int[]{1, 2, 3, 4, 5, 6, 7};
        k = 5;
        System.out.println("INPUT: " + Arrays.toString(input));
        rotateArray3(input, k);
        System.out.println("OUTPUT: " + Arrays.toString(input) + "\n");
    }

}
