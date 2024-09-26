package dsa.binarySearch;

import java.util.Arrays;

public class SearchMinimumInRotatedSortedArray {

//    There is an integer array nums sorted in ascending order.

//    Prior to being passed to your function,
//    nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length)
//    such that the resulting array is
//    [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed).
//    For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3
//    and become [4,5,6,7,0,1,2].

//    Given the array nums after the possible rotation
//    return the index of minimum element if it is in nums, or -1 if it is not.

//    You must write an algorithm with O(log n) runtime complexity.

    private static int binarySearch(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int n = nums.length;

        int start = 0, end = n - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int prev = (mid - 1 + n) % n;
            int next = (mid + 1) % n;
            if (nums[mid] <= nums[prev] && nums[mid] <= nums[next]) {
                return mid;
            } else if (nums[mid] <= nums[end]) {
//                if right is sorted minimum will be on left part
                end = mid - 1;
            } else {
//                if right is not sorted minimum will be on right part
                start = mid + 1;
            }
        }
        return -1;
    }

    private static void solve(int[] nums) {
        System.out.println("INPUT: " + Arrays.toString(nums));
        System.out.println("INDEX: " + binarySearch(nums) + "\n");
    }

    public static void main(String[] args) {
        int[][] input = new int[][]{
                {4, 5, 6, 7, 0, 1, 2},
                {1, 2, 3, 4, 5},
                {2, 3, 4, 5, 1},
                {1, 2},
                {2, 1},
                {1}
        };

        Arrays.stream(input)
                .peek(i -> System.out.println("INPUT: " + Arrays.toString(i)))
                .map(SearchMinimumInRotatedSortedArray::binarySearch)
                .forEach(o -> System.out.println("OUTPUT: " + o + "\n"));
    }
}
