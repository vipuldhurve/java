package dsa.slidingWindow.fixed;

import java.util.*;

public class SlidingWindowMaximum {

//    You are given an array of integers nums,
//    there is a sliding window of size k
//    which is moving from the very left of the array to the very right.
//    You can only see the k numbers in the window.
//    Each time the sliding window moves right by one position.

//    Return the max sliding window.

//    Example 1:
//    Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
//    Output: [3,3,5,5,6,7]

//         Window position               Max
//         ---------------               -----
//        [1  3  -1] -3  5  3  6  7       3
//        1 [3  -1  -3] 5  3  6  7        3
//        1  3 [-1  -3  5] 3  6  7        5
//        1  3  -1 [-3  5  3] 6  7        5
//        1  3  -1  -3 [5  3  6] 7        6
//        1  3  -1  -3  5 [3  6  7]       7


    public static int[] slidingWindowMaximum(int[] nums, int k) {
//        Total values in maxSubArray will be n-k+1
        int[] maxSubArrays = new int[nums.length - k + 1];
        int i = 0;
        int left = 0;
        int right = 0;

        Queue<Integer> queue = new LinkedList<>();

        while (right < nums.length) {
//            If current value is greater than values in queue,
//            Current value will always be greatest then values in queue i.e. values that were present in left of it
//            Remove all the smaller elements than current element from queue and then add
            while (!queue.isEmpty() && nums[right] > queue.peek()) queue.poll();
            queue.offer(nums[right]);

            if (right - left + 1 < k) {
                right++;
            } else if (right - left + 1 == k) {
//                Add max value in ans maxArray - it will be present in queue peek
                maxSubArrays[i++] = queue.peek();
//                If left of array is equal to queue peek
//                Remove from queue before moving window
                if (nums[left] == queue.peek()) queue.poll();
//                move window
                left++;
                right++;
            }
        }

        return maxSubArrays;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        System.out.println( "Input: " + Arrays.toString(nums) + " k = " + k);
        System.out.println("Output: " + Arrays.toString(slidingWindowMaximum(nums, k)));
    }

}
