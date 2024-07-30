package dsa.twoPointers;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class threeSum {
//    Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]]
//    where nums[i] + nums[j] + nums[k] == 0, and the indices i, j and k are all distinct.

//    The output should not contain any duplicate triplets.
//    You may return the output and the triplets in any order.

//    Input: nums = [-1,0,1,2,-1,-4]
//    Output: [[-1,-1,2],[-1,0,1]]

//    Input: nums = [0,1,1]
//    Output: []

//    Input: nums = [0,0,0]
//    Output: [[0,0,0]]
    private static ArrayList<int[]> threeSumSolve(int[] nums) {
        ArrayList<int[]> result = new ArrayList<>();

        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum < 0) {
                    j++;
                } else if (sum > 0) {
                    k--;
                } else {
                    int[] temp = new int[]{nums[i], nums[j], nums[k]};
                    result.add(temp);
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1]) j++;
                    while (j < k && nums[k] == nums[k + 1]) k--;
                }
            }
        }
        return result;
    }

    public static void solve(int[] nums) {
        System.out.println("Input: ");
        System.out.println( Arrays.toString(nums));
        ArrayList<int[]> output = threeSumSolve(nums);

        System.out.println("Output:");
        if (output.size() == 0) {
            System.out.println("[]");
        } else {
            printArray(output);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        solve(nums);

        nums = new int[]{0, 1, 1};
        solve(nums);

        nums = new int[]{0, 0, 0};
        solve(nums);
    }

    private static void printArray(ArrayList<int[]> nums) {
        for (int[] a : nums) {
            System.out.print("[");
            for (int x : a) System.out.print(x + " ");
            System.out.println("]");
        }
    }

}
