package dsa.binarySearch;

import java.util.Arrays;

public class SearchInRotatedSortedArray2 {

    private static int binarySearch(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int n = nums.length;

        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[low] == nums[mid] && nums[mid] == nums[high]) {


                low++;
                high--;
            } else if (nums[low] <= nums[mid]) {
//                if left is sorted check if target lies in left part and eliminate
                if (nums[low] <= target && target <= nums[mid]) high = mid - 1;
                else low = mid + 1;
            } else {
//               if right is sorted check if target lies in right part and eliminate
                if (nums[mid] <= target && target <= nums[high]) low = mid + 1;
                else high = mid - 1;
            }
        }
        return -1;
    }

    private static void solve(int[] nums, int target) {
        System.out.println("Input: " + Arrays.toString(nums) + "  target = " + target);
        System.out.println("Search Index : " + binarySearch(nums, target) + "\n");
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 5, 6, 0, 0, 1, 2};
        int target = 0;
        solve(nums, target);

        target = 2;
        solve(nums, target);

        target = 3;
        solve(nums, target);

        nums = new int[]{3, 1, 3, 3, 3, 3, 3, 3};
        target = 1;
        solve(nums, target);

        nums = new int[]{};
        solve(nums, target);

        nums = null;
        solve(nums, target);
    }
}
