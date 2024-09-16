package dsa.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {
//    You are given an array of integers nums, which may contain duplicates,
//    and a target integer target.
//    Your task is to return a list of all unique combinations of nums
//    where the chosen numbers sum to target.

//    Each element from nums may be chosen at most once within a combination.
//    The solution set must not contain duplicate combinations.

//    You may return the combinations in any order
//    and the order of the numbers in each combination can be in any order.

//    Example 1:
//    Input: candidates = [9,2,2,4,6,1,5], target = 8
//    Output: [
//            [1,2,5],
//            [2,2,4],
//            [2,6]
//            ]

//    Example 2:
//    Input: candidates = [1,2,3,4,5], target = 7
//    Output: [
//            [1,2,4],
//            [2,5],
//            [3,4]
//            ]

    static List<List<Integer>> result;

    private static void findCombinations(int[] candidates, int index, int target, List<Integer> sub) {
        if (target == 0) {
            result.add(new ArrayList<>(sub));
            return;
        }
//         Since array is sorted we stop if nums[i] is greater than target
        if (index >= candidates.length || candidates[index] > target) return;

//        Include
        sub.add(candidates[index]);
        findCombinations(candidates, index + 1, target - candidates[index], sub);
        sub.remove(sub.size() - 1);

//        Not include and skip all same values
        while (index + 1 < candidates.length && candidates[index] == candidates[index + 1]) index++;
        findCombinations(candidates, index + 1, target, sub);
    }

    private static void solve(int[] candidates, int target) {
//        Sort input array
        Arrays.sort(candidates);
        System.out.println("INPUT: " + Arrays.toString(candidates) + " Target = " + target);
        result = new ArrayList<>();
        findCombinations(candidates, 0, target, new ArrayList<>());
        System.out.println("OUTPUT: " + result.toString() + "\n");
        System.out.println();
    }

    public static void main(String[] args) {
        int[] input = new int[]{9, 2, 2, 4, 6, 1, 5};
        int target = 8;
        solve(input, target);

        input = new int[]{1, 2, 2, 2, 3};
        target = 5;
        solve(input, target);

        input = new int[]{1, 2, 3, 4, 5};
        target = 7;
        solve(input, target);
    }
}
