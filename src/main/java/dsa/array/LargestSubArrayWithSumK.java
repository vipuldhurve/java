package dsa.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LargestSubArrayWithSumK {
//    Array has NEGATIVE INTEGERS ALSO!!!

//    Given an array arr containing n integers and an integer k.
//    find the length of the longest Sub-Array with the sum of the elements
//    equal to the given value k

//    Input : arr[] = {10, 5, 2, 7, 1, 9}, k = 15
//    Output : 4

//    Input : arr[] = {1, 2, 3}, k = 6
//    Output : 0

//    Input: arr[] = {4, 1, 1, -2, 1};
//    Output = 5

    //    TIME COMPLEXITY: O(N)   |   SPACE COMPLEXITY: O(N)
    private static int[] largestArrayOfSumK(int[] nums, int sum) {
        Map<Integer, Integer> prefixMap = new HashMap<>();
        int prefixSum = 0;
        int maxLen = 0;
        int start = -1, end = -1;
        for (int index = 0; index < nums.length; index++) {
            prefixSum += nums[index];
//            If prefixSum equals sum Check ans
            if (prefixSum == sum) {
                if (maxLen < index + 1) {
                    maxLen = index + 1;
                    start = 0;
                    end = index;
                }
            }

            if (prefixMap.containsKey(prefixSum - sum)) {
                int prevIndex = prefixMap.get(prefixSum - sum);
                if (maxLen < index - prevIndex) {
                    maxLen = index - prevIndex;
                    start = prevIndex + 1;
                    end = index;
                }
            }

            prefixMap.put(prefixSum, index);
        }

//        Copy and return sub array
        if (start == end) return new int[0];
        int[] ans = new int[end - start + 1];
        for (int x = start, y = 0; x <= end; x++, y++) ans[y] = nums[x];
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

        nums = new int[]{4, 1, 1, -2, 1};
        sum = 5;
        solve(nums, sum);
    }
}
