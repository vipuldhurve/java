package dsa.slidingWindow.fixed;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class FirstNegativeInKSizeWindow {
//    Given an array and a positive integer k,
//    find the first negative integer for each window(contiguous subarray) of size k
//    If a window does not contain a negative integer, then print 0 for that window

//    Input : arr[] = {-8, 2, 3, -6, 10}, k = 2
//    Output : -8 0 -6 -6

//    Input : arr[] = {12, -1, -7, 8, -15, 30, 16, 28} , k = 3
//    Output : -1 -1 -7 -15 -15 0

    public static int[] FirstNegativesInKWindow(int[] nums, int k) {
//        Total values in firstNegatives will be n-k+1
        int[] firstNegatives = new int[nums.length - k + 1];
        int i = 0;
        int left = 0;
        int right = 0;

        Queue<Integer> q = new LinkedList<>();

        while (right < nums.length) {
//            if negative found added in q
            if (nums[right] < 0) q.add(nums[right]);

//            Slide window
            if (right - left + 1 < k) {
                right++;
            } else if (right - left + 1 == k) {
                if (q.isEmpty()) {
                    firstNegatives[i++] = 0;
                } else {
                    firstNegatives[i++] = q.peek();
                    if (nums[left] < 0) q.poll();
                }
                left++;
                right++;
            }
        }
        return firstNegatives;
    }

    private static void solve(int[] nums, int k) {
        System.out.println("Input: " + Arrays.toString(nums) + " k = " + k);
        System.out.println("Output: " + Arrays.toString(FirstNegativesInKWindow(nums, k)) + "\n");
    }

    public static void main(String[] args) {
        int[] nums = new int[]{12, -1, -7, 8, -15, 30, 16, 28};
        int k = 3;
        solve(nums, k);

        nums = new int[]{-8, 2, 3, -6, 10};
        k = 2;
        solve(nums, k);
    }
}
