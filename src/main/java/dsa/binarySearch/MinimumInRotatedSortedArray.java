package dsa.binarySearch;

import java.util.Arrays;

public class MinimumInRotatedSortedArray {
//    You are given an array of length n which was originally sorted in ascending order.
//    It has now been rotated between 1 and n times.
//    For example, the array nums = [1,2,3,4,5,6] might become:

//    1. [3,4,5,6,1,2] if it was rotated 4 times.
//    2. [1,2,3,4,5,6] if it was rotated 6 times.

//    Notice that rotating the array 4 times moves the last four elements
//    of the array to the beginning.
//    Rotating the array 6 times produces the original array.

//    Assuming all elements in the rotated sorted array nums are unique,
//    return the index of minimum element of this array.

    private static int binarySearch(int[] nums) {
        int n = nums.length;
        if (n == 0) return -1;

        int left = 0;
        int right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int prev = (mid - 1 + n) % n;
            int next = (mid + 1) % n;
//            Minimum element will be smaller than all the elements
//            and thus smaller from its neighbours
            if (nums[mid] <= nums[prev] && nums[mid] <= nums[next]) return mid;
            else if (nums[mid] <= nums[right]) right = mid - 1;
            else left = mid + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] inputArrays = new int[][]{
                {3, 4, 5, 6, 1, 2},
                {4, 5, 0, 1, 2, 3},
                {4, 5, 6, 7},
                {7, 6, 5, 4}
        };

        Arrays.stream(inputArrays)
                .peek(arr -> System.out.println("INPUT: " + Arrays.toString(arr)))
                .map(MinimumInRotatedSortedArray::binarySearch)
                .forEach(el -> System.out.println("OUTPUT: " + el + "\n"));
    }
}
